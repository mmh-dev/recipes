package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;

public class Favourites extends AppCompatActivity {

    List<Recipe> favouritesList;
    ImageView deleteIcon;
    FAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        Intent intent = getIntent();
        favouritesList = (List<Recipe>) intent.getSerializableExtra("favourites");
        adapter = new FAdapter(this, favouritesList);
        RecyclerView favouritesView = findViewById(R.id.favouritesView);
        favouritesView.setLayoutManager(new LinearLayoutManager(this));
        favouritesView.setAdapter(adapter);

        deleteIcon = findViewById(R.id.deleteIcon);

        adapter.setOnItemClickListener(new FAdapter.FavouritesOnClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(Favourites.this, RecipeDetails.class);
                intent.putExtra("RecipeDetails", (Serializable) favouritesList.get(position));
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                fremove(position);
            }
        });



    }

    private void fremove(int position) {
        favouritesList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}