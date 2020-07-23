package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Recipe> recipeList =new ArrayList<>();
        recipeList.add(new Recipe(R.drawable.gaspacho, "Суп Гаспачо", R.string.gaspacho_desc, "30 мин", "45 Ккал"));
        recipeList.add(new Recipe(R.drawable.pasta, "Паста \"Три Сыра\"", R.string.pasta_desc, "25 мин", "337 Ккал"));
        recipeList.add(new Recipe(R.drawable.chicken, "Курица с яблоками", R.string.chicken_desc, "40 мин", "127 Ккал"));
        recipeList.add(new Recipe(R.drawable.lakhmadzhun, "Лахмаджун", R.string.lakhmanzhun_desc, "60 мин", "160 Ккал"));
        recipeList.add(new Recipe(R.drawable.pizza, "Пицца детская", R.string.pizza_desc, "60 мин", "212 Ккал"));
        recipeList.add(new Recipe(R.drawable.tiramisu, "Тирамису", R.string.tiramisu_desc, "40 мин", "239 Ккал"));
        recipeList.add(new Recipe(R.drawable.teriyaki, "Курица Терияки", R.string.teriyaki_desc, "15 мин", "111 Ккал"));
        recipeList.add(new Recipe(R.drawable.kebab, "Люля Кебаб", R.string.kebab_desc, "60 мин", "184 Ккал"));
        recipeList.add(new Recipe(R.drawable.puding, "Манный Пудинг", R.string.puding_desc, "60 мин", "114 Ккал"));
        recipeList.add(new Recipe(R.drawable.dolma, "Долма", R.string.dolma_desc, "90 мин", "206 Ккал"));

        RecipeAdapter adapter = new RecipeAdapter(this, recipeList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}