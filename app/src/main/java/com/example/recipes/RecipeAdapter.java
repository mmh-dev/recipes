package com.example.recipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Holder> implements Filterable {

    List<Recipe> recipeList;
    List<Recipe> recipeListAll;
    Context context;
    RecycleOnClickListener listener;

    public void setOnItemClickListener (RecycleOnClickListener listener){
        this.listener = listener;
    }

    public RecipeAdapter(Context context, List<Recipe> recipeList){
        this.context = context;
        this.recipeList = recipeList;
        recipeListAll = new ArrayList<>(recipeList);
    }

    @NonNull
    @Override
    public RecipeAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Holder(view, listener);
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

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Recipe> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(recipeListAll);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Recipe r: recipeListAll) {
                    if (r.getRecipeName().toLowerCase().contains(filterPattern)){
                        filteredList.add(r);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            recipeList.clear();
            recipeList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView image, favouritesIcon;
        TextView name;
        TextView desc;
        ImageView cookingTimeImage;
        ImageView caloriesImage;
        TextView cookingTime;
        TextView calories;


        public Holder(@NonNull View itemView, final RecycleOnClickListener listener) {
            super(itemView);

            image = itemView.findViewById(R.id.recipe_image);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            cookingTimeImage = itemView.findViewById(R.id.time_icon);
            caloriesImage = itemView.findViewById(R.id.calories_icon);
            cookingTime = itemView.findViewById(R.id.cookingTime);
            calories = itemView.findViewById(R.id.caloriesValue);
            favouritesIcon = itemView.findViewById(R.id.favouritesIcon);

            favouritesIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onFavouritesClick(position);
                    favouritesIcon.setImageResource(R.drawable.ic_baseline_favorite_24);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });
        }
    }

    public interface RecycleOnClickListener{
        void onItemClick (int position);
        void onFavouritesClick (int position);
    }
}
