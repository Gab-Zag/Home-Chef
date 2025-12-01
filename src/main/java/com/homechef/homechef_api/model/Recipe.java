package com.homechef.homechef_api.model;

import java.util.List;

public class Recipe {
    private String id;
    private String name;
    private String category;
    private String area;
    private String instructions;
    private String image;
    private String ingredients;
    private String measures;


    public Recipe() {}

    public Recipe(String id, String name, String category, String area,
                  String instructions, String image, String ingredients, String measures) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.area = area;
        this.instructions = instructions;
        this.image = image;
        this.ingredients = ingredients;
        this.measures = measures;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String setIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = Recipe.this.ingredients; }

    public String getMeasure() { return measures; }
    public void setMeasure(String measure) { this.measures = measure; }
}