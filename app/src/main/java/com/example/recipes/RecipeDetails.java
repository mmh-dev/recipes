package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetails extends AppCompatActivity {

    Recipe recipe;
    ImageView recipeImage;
    TextView recipeName, cookingTime, caloriesValue, portions, recipeDetails, ingredients, history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        Intent intent = getIntent();
        recipe = (Recipe) intent.getSerializableExtra("RecipeDetails");

        recipeImage = findViewById(R.id.recipe_image_details);
        recipeName = findViewById(R.id.recipeName);
        cookingTime = findViewById(R.id.cooking_time);
        caloriesValue = findViewById(R.id.calories_value);
        portions = findViewById(R.id.portions);
        recipeDetails = findViewById(R.id.recipeDetails);
        ingredients = findViewById(R.id.ingredients);
        history = findViewById(R.id.recipe_history);

        recipeImage.setImageResource(recipe.getRecipeImage());
        recipeName.setText(recipe.getRecipeName());
        cookingTime.setText(recipe.getRecipeCookingTime());
        caloriesValue.setText(recipe.getRecipeCalories());
        portions.setText(String.valueOf(recipe.getPortions()));
        recipeDetails.setText(recipe.getRecipeDetails());
        ingredients.setText(recipe.getIngredients());
        history.setText(recipe.getHistory());

    }
}