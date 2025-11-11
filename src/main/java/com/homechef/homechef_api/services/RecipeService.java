package com.homechef.homechef_api.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.Json;
import com.homechef.homechef_api.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReciveService {

    private static final String API_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public RecipeService(){
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public List<Recipe> searchByIngredients(String ingredients){
        List<Recipe> recipes = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(API_URL + ingredients, String.class);
            JsonNode root = objectMapper.readTree(response);

            JsonNode meals = root.path("meal");
            if (meals.isArray()){
                for (JsonNode meal : meals){
                    Recipe recipe = new Recipe(
                            meal.path("strMeal").asText(),
                            "Unknow",
                            "Clique para ver detalhes",
                            meal.path("strMealThumb").asText()
                    );
                    recipe.add(recipe);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return recipes;
    }
}
