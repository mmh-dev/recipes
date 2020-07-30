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

public class FAdapter  extends RecyclerView.Adapter<FAdapter.Holder> {

    List<Recipe> favouritesList;
    Context context;
    FavouritesOnClickListener listener;

    public void setOnItemClickListener (FavouritesOnClickListener listener){
        this.listener = listener;
    }

    public FAdapter(Context context, List<Recipe> favouritesList){
        this.favouritesList = favouritesList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourites_item, parent, false);
        return new Holder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.image.setImageResource(favouritesList.get(position).getRecipeImage());
        holder.name.setText(favouritesList.get(position).getRecipeName());
        holder.desc.setText(favouritesList.get(position).getRecipeDesc());
        holder.cookingTime.setText(favouritesList.get(position).getRecipeCookingTime());
        holder.calories.setText(favouritesList.get(position).getRecipeCalories());
    }

    @Override
    public int getItemCount() {
        return favouritesList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView image, deleteIcon;
        TextView name;
        TextView desc;
        ImageView cookingTimeImage;
        ImageView caloriesImage;
        TextView cookingTime;
        TextView calories;

        public Holder(@NonNull View itemView, final FavouritesOnClickListener listener) {
            super(itemView);

            image = itemView.findViewById(R.id.recipe_image);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            cookingTimeImage = itemView.findViewById(R.id.time_icon);
            caloriesImage = itemView.findViewById(R.id.calories_icon);
            cookingTime = itemView.findViewById(R.id.cookingTime);
            calories = itemView.findViewById(R.id.caloriesValue);
            deleteIcon = itemView.findViewById(R.id.deleteIcon);

            deleteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDeleteClick(getAdapterPosition());
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

    public interface FavouritesOnClickListener{
        void onItemClick (int position);
        void onDeleteClick (int position);
    }
}
