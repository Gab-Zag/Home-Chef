package com.homechef.homechef_api.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homechef.homechef_api.model.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Mock
    ObjectMapper objectMapper;

    @InjectMocks
    RecipeService service;

    @Test
    void searchByIngredientsReturnsMappedRecipes() throws Exception {
        String jsonResponse = """
                {
                  "meals": [
                    {
                      "idMeal": "52772",
                      "strMeal": "Teriyaki Chicken",
                      "strMealThumb": "img.png"
                    }
                  ]
                }
                """;

        when(restTemplate.getForObject(
                "https://www.themealdb.com/api/json/v1/1/filter.php?i=chicken",
                String.class
        )).thenReturn(jsonResponse);

        var mapper = new ObjectMapper();
        var jsonNode = mapper.readTree(jsonResponse);
        when(objectMapper.readTree(jsonResponse)).thenReturn(jsonNode);

        List<Recipe> result = service.searchByIngredients("chicken");

        assertEquals(1, result.size());
        assertEquals("52772", result.get(0).getId());
        assertEquals("Teriyaki Chicken", result.get(0).getName());
        assertEquals("img.png", result.get(0).getImage());
    }

    @Test
    void searchEmptyIngredientsReturnsEmptyList() throws Exception {
        when(restTemplate.getForObject(
                "https://www.themealdb.com/api/json/v1/1/filter.php?i=",
                String.class
        )).thenReturn("{\"meals\": null}");

        when(objectMapper.readTree("{\"meals\": null}"))
                .thenReturn(new ObjectMapper().readTree("{\"meals\": null}"));

        List<Recipe> result = service.searchByIngredients("");
        assertTrue(result.isEmpty());
    }

    @Test
    void getRecipeDetailsReturnsFullRecipe() throws Exception {
        String id = "52772";

        String jsonResponse = "{\n" +
                "  \"meals\": [\n" +
                "    {\n" +
                "      \"idMeal\": \"52772\",\n" +
                "      \"strMeal\": \"Teriyaki Chicken\",\n" +
                "      \"strCategory\": \"Chicken\",\n" +
                "      \"strInstructions\": \"Cook the chicken...\",\n" +
                "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        when(restTemplate.getForObject(
                "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + id,
                String.class
        )).thenReturn(jsonResponse);

        JsonNode root = new ObjectMapper().readTree(jsonResponse);
        when(objectMapper.readTree(jsonResponse)).thenReturn(root);

        Recipe recipe = service.getRecipeDetails(id);

        assertNotNull(recipe);
        assertEquals("52772", recipe.getId());
        assertEquals("Teriyaki Chicken", recipe.getName());
        assertEquals("Chicken", recipe.getCategory());
        assertEquals("Cook the chicken...", recipe.getInstructions());
        assertEquals(
                "https://www.themealdb.com/images/media/meals/wvpsxx1468256321.jpg",
                recipe.getImage()
        );
    }


}
