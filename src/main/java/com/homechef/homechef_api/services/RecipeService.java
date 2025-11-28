package com.homechef.homechef_api.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homechef.homechef_api.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private static final String API_SEARCH_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=";
    private static final String API_DETAILS_URL = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public RecipeService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<Recipe> searchByIngredients(String ingredients) {
        List<Recipe> recipes = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(API_SEARCH_URL + ingredients, String.class);

            if (response == null) return recipes;

            JsonNode root = objectMapper.readTree(response);
            if (root == null || root.path("meals").isNull()) return recipes;

            JsonNode meals = root.path("meals");
            if (meals.isArray()) {
                for (JsonNode meal : meals) {
                    Recipe recipe = new Recipe();
                    recipe.setId(meal.path("idMeal").asText());
                    recipe.setName(meal.path("strMeal").asText());
                    recipe.setCategory("Unknown");
                    recipe.setInstructions("Clique para ver detalhes");
                    recipe.setImage(meal.path("strMealThumb").asText());
                    recipes.add(recipe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipes;
    }


    public Recipe getRecipeDetails(String id) {
        try {
            String response = restTemplate.getForObject(API_DETAILS_URL + id, String.class);
            JsonNode root = objectMapper.readTree(response);

            JsonNode meal = root.path("meals").get(0);

            return new Recipe(
                    meal.path("idMeal").asText(),
                    meal.path("strMeal").asText(),
                    meal.path("strCategory").asText(),
                    meal.path("strArea").asText(),
                    meal.path("strInstructions").asText(),
                    meal.path("strMealThumb").asText()
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
