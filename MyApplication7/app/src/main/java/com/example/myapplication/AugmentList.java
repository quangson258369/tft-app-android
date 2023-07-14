package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Models.Augment;
import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.Item;
import com.example.myapplication.adapter.Augment_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AugmentList extends AppCompatActivity {

    private RecyclerView rcvAugment;
    private Augment_Adapter aug_Adapter;
    
    private List<Augment> ListAugments = new ArrayList<>();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_augment_list);

        readJsonFile();

        rcvAugment = findViewById(R.id.rcv_augment);

        aug_Adapter = new Augment_Adapter(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rcvAugment.setLayoutManager(linearLayoutManager);

        aug_Adapter.setData(getListAugmentsByLevel(1));
        rcvAugment.setAdapter(aug_Adapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.top_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_level1);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.action_level1) {
                aug_Adapter.setData(getListAugmentsByLevel(1));
                rcvAugment.setAdapter(aug_Adapter);
            } else if (item.getItemId() == R.id.action_level2) {
                aug_Adapter.setData(getListAugmentsByLevel(2));
                rcvAugment.setAdapter(aug_Adapter);
            } else if (item.getItemId() == R.id.action_level3) {
                aug_Adapter.setData(getListAugmentsByLevel(3));
                rcvAugment.setAdapter(aug_Adapter);
            }else {
                aug_Adapter.setData(getListAugmentsByLevel(4));
                rcvAugment.setAdapter(aug_Adapter);
            }

            return true;
        });

    }


    private ArrayList<Augment> getListAugmentsByLevel(int level) {

        ArrayList<Augment> list = new ArrayList<>();

        for (int i = 0; i < ListAugments.size(); i++) {
            if (ListAugments.get(i).getLevel() == level) {
                list.add(new Augment(ListAugments.get(i).getName(), ListAugments.get(i).getDescription(), GetChampionImageByName(ListAugments.get(i).getIcon())));
                Log.d("NGU", String.valueOf(GetChampionImageByName(ListAugments.get(i).getIcon())));
            }
        }
        return list;
    }


    private void readJsonFile() {
        try {
            // Read the JSON file from the assets folder
            InputStream inputStream = getAssets().open("augments_en_US.json");
            // Check if the inputStream is null
            if (inputStream != null) {
                BufferedReader reader3 = new BufferedReader(new InputStreamReader(inputStream));

                // Use Gson to parse the JSON data into objects
                Gson gson = new Gson();

                // Define the type of your data. For example, if your JSON represents a list of champions:
                Type listType3 = new TypeToken<List<Augment>>() {
                }.getType();

                // Parse the JSON data into a list of Champion objects
                ListAugments = gson.fromJson(reader3, listType3);
                // Now you have the extracted data in the championList
                // You can use it as needed
                // ...

                // Close the input stream
                inputStream.close();
            } else {
                // Handle the case when the inputStream is null
                Log.e("JSON File", "Failed to open the JSON file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bitmap GetChampionImageByName(String name) {
        String ChampionNameImage = "augments/" + name + ".png";
        try {
            InputStream inputStream = getAssets().open(ChampionNameImage);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}