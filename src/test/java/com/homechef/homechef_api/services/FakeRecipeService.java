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
    public List<Recipe> searchByIngredients(String ingredientsQuery) {
        return List.of(
                new Recipe(
                        "1",
                        "Chicken Curry",
                        "Chicken",
                        "Indian",
                        "Mix everything and cook for 20 minutes.",
                        "img.png",
                        "Chicken, Curry Powder, Salt",
                        "500g, 2 tbsp, to taste"
                )
        );
    }

    @Override
    public Recipe getRecipeDetails(String id) {
        return new Recipe(
                "99",
                "Beef Steak",
                "Beef",
                "USA",
                "Season and grill until desired doneness.",
                "photo.png",
                "Beef, Salt, Garlic",
                "1kg, 1 tsp, 2 cloves"
        );
    }
}
