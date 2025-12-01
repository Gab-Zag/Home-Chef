package com.homechef.homechef_api.controller;

import com.homechef.homechef_api.services.FakeRecipeService;
import com.homechef.homechef_api.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public RecipeService recipeService() {
            return new FakeRecipeService();
        }
    }

    @Test
    void searchRecipe_ShouldReturnRecipeList() throws Exception {
        mockMvc.perform(get("/recipes/search")
                        .param("ingredients", "chicken"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Chicken Curry"))
                .andExpect(jsonPath("$[0].image").value("img.png"));
    }

    @Test
    void getRecipeDetails_ShouldReturnRecipe() throws Exception {
        mockMvc.perform(get("/recipes/details")
                        .param("id", "99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("99"))
                .andExpect(jsonPath("$.name").value("Beef Steak"))
                .andExpect(jsonPath("$.category").value("Beef"))
                .andExpect(jsonPath("$.area").value("USA"))
                .andExpect(jsonPath("$.instructions").value("Season and grill until desired doneness."))
                .andExpect(jsonPath("$.image").value("photo.png"));
    }
}
