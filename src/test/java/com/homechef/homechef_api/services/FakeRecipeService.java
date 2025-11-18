package com.homechef.homechef_api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homechef.homechef_api.model.Recipe;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FakeRecipeService extends RecipeService {

    public FakeRecipeService() {
        super(new RestTemplate(), new ObjectMapper());
    }

    @Override
    public List<Recipe> searchByIngredients(String ingredients) {
        return List.of(
                new Recipe("1", "Chicken Curry", "Category", "Area", "Instructions", "img.png")
        );
    }

    @Override
    public Recipe getRecipeDetails(String id) {
        return new Recipe("99", "Beef Steak", "Beef", "USA", "Cook it well", "photo.png");
    }
}

