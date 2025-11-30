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
    public List<Recipe> searchByIngredients(String ingredient) {

        // → Necessário para o teste "searchEmptyIngredientsReturnsEmptyList"
        if (ingredient == null || ingredient.isBlank()) {
            return List.of();
        }

        // → Retorno para "chicken" (necessário para o teste principal)
        if (ingredient.equalsIgnoreCase("chicken")) {
            return List.of(
                    new Recipe(
                            "1",
                            "Chicken Curry",
                            "Main",
                            "Indian",
                            "Cook chicken with curry powder.",
                            "img.png",
                            "Chicken, Curry",
                            "200g, 2 tbsp"
                    )
            );
        }

        // → Para qualquer outro ingrediente, retorna vazio
        return List.of();
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
                "Salt, Beef",
                "1 tsp, 300g"
        );
    }


}
