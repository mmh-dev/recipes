package com.example.recipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Holder> {

    List<Recipe> recipeList;
    Context context;

    public RecipeAdapter(Context context, List<Recipe> recipeList){
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.Holder holder, int position) {
        holder.image.setImageResource(recipeList.get(position).getRecipeImage());
        holder.name.setText(recipeList.get(position).getRecipeName());
        holder.desc.setText(recipeList.get(position).getRecipeDesc());
        holder.cookingTime.setText(recipeList.get(position).getRecipeCookingTime());
        holder.calories.setText(recipeList.get(position).getRecipeCalories());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView desc;
        ImageView cookingTimeImage;
        ImageView caloriesImage;
        TextView cookingTime;
        TextView calories;


        public Holder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.recipe_image);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            cookingTimeImage = itemView.findViewById(R.id.time_icon);
            caloriesImage = itemView.findViewById(R.id.calories_icon);
            cookingTime = itemView.findViewById(R.id.cookingTime);
            calories = itemView.findViewById(R.id.caloriesValue);

        }
    }
}
