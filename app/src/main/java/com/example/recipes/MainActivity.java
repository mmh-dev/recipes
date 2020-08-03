package com.example.recipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Recipe> recipeList = new ArrayList<>();
    List<Recipe> favouritesList = new ArrayList<>();
    ImageView favouritesIcon;
    int count = 0;
    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeList.add(new Recipe(R.drawable.gaspacho, "Суп Гаспачо", R.string.gaspacho_desc, "30 мин", "45 Ккал", 4, R.string.gaspacho_recipe, R.string.gaspacho_ingredients, R.string.gaspacho_history));
        recipeList.add(new Recipe(R.drawable.pasta, "Паста \"Три Сыра\"", R.string.pasta_desc, "25 мин", "337 Ккал", 3, R.string.pasta_recipe, R.string.pasta_ingredients, R.string.pasta_history));
        recipeList.add(new Recipe(R.drawable.chicken, "Курица с яблоками", R.string.chicken_desc, "40 мин", "127 Ккал", 3, R.string.chicken_recipe, R.string.chicken_ingredients, R.string.chicken_history));
        recipeList.add(new Recipe(R.drawable.lakhmadzhun, "Лахмаджун", R.string.lakhmanzhun_desc, "60 мин", "160 Ккал",6, R.string.lakhmanzhun_recipe, R.string.lakhmanzhun_ingredients, R.string.lakhmanzhun_history));
        recipeList.add(new Recipe(R.drawable.pizza, "Пицца детская", R.string.pizza_desc, "60 мин", "212 Ккал", 4, R.string.pizza_recipe, R.string.pizza_ingredients, R.string.pizza_history));
        recipeList.add(new Recipe(R.drawable.tiramisu, "Тирамису", R.string.tiramisu_desc, "40 мин", "239 Ккал",4, R.string.tiramisu_recipe, R.string.tiramisu_ingredients, R.string.tiramisu_history));
        recipeList.add(new Recipe(R.drawable.teriyaki, "Курица Терияки", R.string.teriyaki_desc, "15 мин", "111 Ккал",4, R.string.teriyaki_recipe, R.string.teriyaki_ingredients, R.string.teriyaki_history));
        recipeList.add(new Recipe(R.drawable.kebab, "Люля Кебаб", R.string.kebab_desc, "60 мин", "184 Ккал", 4, R.string.kebab_recipe, R.string.kebab_ingredients, R.string.kebab_history));
        recipeList.add(new Recipe(R.drawable.puding, "Манный Пудинг", R.string.puding_desc, "60 мин", "114 Ккал",4, R.string.puding_recipe, R.string.puding_ingredients, R.string.puding_history));
        recipeList.add(new Recipe(R.drawable.dolma, "Долма", R.string.dolma_desc, "90 мин", "206 Ккал",3 , R.string.dolma_recipe, R.string.dolma_ingredients, R.string.dolma_history));

        adapter = new RecipeAdapter(this, recipeList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        favouritesIcon = findViewById(R.id.favouritesIcon);

        adapter.setOnItemClickListener(new RecipeAdapter.RecycleOnClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                intent.putExtra("RecipeDetails", (Serializable) recipeList.get(position));
                startActivity(intent);
            }

            @Override
            public void onFavouritesClick(int position) {
                if (isAdded(favouritesList, recipeList.get(position))) {
                    Toast.makeText(MainActivity.this, recipeList.get(position).getRecipeName() + "is already in the favourites list!", Toast.LENGTH_SHORT).show();
                }
                else {
                    favouritesList.add(recipeList.get(position));
                    Toast.makeText(MainActivity.this, favouritesList.get(count).getRecipeName() + " added to favourites!", Toast.LENGTH_SHORT).show();
                    count++;
                }
            }
        });

    }

    public boolean isAdded(List<Recipe> recipeList, Recipe recipe){
        for (Recipe r: recipeList) {
            if (r.getRecipeName().equals(recipe.getRecipeName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favourites, menu);

        MenuItem searchItem = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView)searchItem.getActionView();  // searchView is now like a normal EditView
        searchView.setImeOptions(EditorInfo.IME_FLAG_FORCE_ASCII);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.favouritesMenu){
            Intent intent = new Intent(MainActivity.this, Favourites.class);
            intent.putExtra("favourites", (Serializable) favouritesList);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}