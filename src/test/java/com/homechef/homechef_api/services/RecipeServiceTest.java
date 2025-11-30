package com.homechef.homechef_api.services;

import com.homechef.homechef_api.model.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeServiceTest {

    RecipeService service = new FakeRecipeService();

    @Test
    void searchByIngredientsReturnsMappedRecipes() {
        List<Recipe> result = service.searchByIngredients("chicken");

        assertEquals(1, result.size());

        Recipe r = result.get(0);
        assertEquals("1", r.getId());
        assertEquals("Chicken Curry", r.getName());
        assertEquals("img.png", r.getImage());
    }

    @Test
    void searchEmptyIngredientsReturnsEmptyList() {
        List<Recipe> result = service.searchByIngredients("");
        assertTrue(result.isEmpty());
    }

    @Test
    void getRecipeDetailsReturnsFullRecipe() {
        Recipe recipe = service.getRecipeDetails("99");

        assertNotNull(recipe);
        assertEquals("99", recipe.getId());
        assertEquals("Beef Steak", recipe.getName());
        assertEquals("Beef", recipe.getCategory());
        assertEquals("Season and grill until desired doneness.", recipe.getInstructions());
        assertEquals("photo.png", recipe.getImage());
    }
}
