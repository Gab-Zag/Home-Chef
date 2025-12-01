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

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try {
            String response = restTemplate.getForObject(
                    "https://www.themealdb.com/api/json/v1/1/search.php?s=",
                    String.class
            );

            if (response == null) return recipes;

            JsonNode root = objectMapper.readTree(response);
            JsonNode meals = root.path("meals");

            if (!meals.isArray()) return recipes;

            for (JsonNode meal : meals) {
                recipes.add(new Recipe(
                        meal.path("idMeal").asText(),
                        meal.path("strMeal").asText(),
                        meal.path("strCategory").asText(),
                        meal.path("strArea").asText(),
                        meal.path("strInstructions").asText(),
                        meal.path("strMealThumb").asText(),
                        null,  // ingredients removido
                        null   // measures removido
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipes;
    }


    public List<Recipe> searchByIngredients(String ingredientsQuery) {
        List<Recipe> recipes = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(API_SEARCH_URL + ingredientsQuery, String.class);
            if (response == null) return recipes;

            JsonNode root = objectMapper.readTree(response);
            JsonNode meals = root.path("meals");

            if (!meals.isArray()) return recipes;

            for (JsonNode meal : meals) {
                String id = meal.path("idMeal").asText();

                String detailResponse = restTemplate.getForObject(API_DETAILS_URL + id, String.class);
                JsonNode detailRoot = objectMapper.readTree(detailResponse);
                JsonNode details = detailRoot.path("meals").get(0);

                recipes.add(new Recipe(
                        id,
                        details.path("strMeal").asText(),
                        details.path("strCategory").asText(),
                        details.path("strArea").asText(),
                        "Clique para ver detalhes",
                        details.path("strMealThumb").asText(),
                        "",
                        ""
                ));
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

            StringBuilder ingredients = new StringBuilder();
            StringBuilder measures = new StringBuilder();

            for (int i = 1; i <= 20; i++) {
                String ing = meal.path("strIngredient" + i).asText();
                String measure = meal.path("strMeasure" + i).asText();

                if (ing != null && !ing.isEmpty() && !ing.equals("null")) {
                    ingredients.append(ing.trim()).append(i < 20 ? ", " : "");
                    measures.append(measure != null ? measure.trim() : "").append(i < 20 ? ", " : "");
                }
            }

            return new Recipe(
                    meal.path("idMeal").asText(),
                    meal.path("strMeal").asText(),
                    meal.path("strCategory").asText(),
                    meal.path("strArea").asText(),
                    meal.path("strInstructions").asText(),
                    meal.path("strMealThumb").asText(),
                    ingredients.toString(),
                    measures.toString()
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
