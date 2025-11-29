package com.homechef.homechef_api.controller;

import com.homechef.homechef_api.model.Recipe;
import com.homechef.homechef_api.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    // Retorna todas as receitas
    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // Busca receitas por ingrediente
    @GetMapping("/search")
    public List<Recipe> searchRecipe(@RequestParam String ingredients){
        return recipeService.searchByIngredients(ingredients);
    }

    // Retorna detalhes de uma receita específica
    @GetMapping("/details")
    public Recipe getRecipeDetails(@RequestParam String id){
        return recipeService.getRecipeDetails(id);
    }
}
