package com.example.recipes;

public class Recipe {

    private int recipeImage;
    private String recipeName;
    private int recipeDesc;
    private String recipeCookingTime;
    private String recipeCalories;

    public Recipe(int recipeImage, String recipeName, int recipeDesc, String recipeCookingTime, String recipeCalories) {
        this.recipeImage = recipeImage;
        this.recipeName = recipeName;
        this.recipeDesc = recipeDesc;
        this.recipeCookingTime = recipeCookingTime;
        this.recipeCalories = recipeCalories;
    }

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
}
