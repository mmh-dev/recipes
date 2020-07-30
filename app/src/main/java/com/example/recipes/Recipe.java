package com.example.recipes;

import java.io.Serializable;

public class Recipe implements Serializable {

    private int recipeImage;
    private String recipeName;
    private int recipeDesc;
    private String recipeCookingTime;
    private String recipeCalories;
    private int portions;
    private int recipeDetails;
    private int ingredients;
    private int history;

    public int getRecipeImage() {
        return recipeImage;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getRecipeDesc() {
        return recipeDesc;
    }

    public String getRecipeCookingTime() {
        return recipeCookingTime;
    }

    public String getRecipeCalories() {
        return recipeCalories;
    }

    public int getPortions() {
        return portions;
    }

    public int getRecipeDetails() {
        return recipeDetails;
    }

    public int getIngredients() {
        return ingredients;
    }

    public int getHistory() {
        return history;
    }

    public Recipe(int recipeImage, String recipeName, int recipeDesc, String recipeCookingTime, String recipeCalories, int portions, int recipeDetails, int ingredients, int history) {
        this.recipeImage = recipeImage;
        this.recipeName = recipeName;
        this.recipeDesc = recipeDesc;
        this.recipeCookingTime = recipeCookingTime;
        this.recipeCalories = recipeCalories;
        this.portions = portions;
        this.recipeDetails = recipeDetails;
        this.ingredients = ingredients;
        this.history = history;
    }
}
