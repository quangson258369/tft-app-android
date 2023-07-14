package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.Item;
import com.example.myapplication.Models.ItemCompUse;
import com.example.myapplication.Models.Suggestion;
import com.example.myapplication.adapter.Item_Adapter;
import com.example.myapplication.adapter.Suggestion_Adapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ItemManager extends AppCompatActivity  {

    private List<Item> ListItems = new ArrayList<>();
    private List<ItemCompUse> ListItemComp = new ArrayList<>();
    private Item_Adapter item_adapter = new Item_Adapter();

    RecyclerView recyclerView;
    androidx.appcompat.widget.SearchView searchView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_manager);
        recyclerView = findViewById(R.id.recycler_view);

        readJsonFile();
        GetDataItem();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
         Log.d("TAG",ListItemComp.get(1).getNameItem());

        item_adapter.setData(ListItemComp);
        recyclerView.setAdapter(item_adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.item_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView= (androidx.appcompat.widget.SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                item_adapter.getFilter().filter(newText);
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String newText) {
                return false;
            }
        });
        return true;
    }
    private void readJsonFile() {
        try {
            // Read the JSON file from the assets folder
            InputStream inputStream2 = getAssets().open("items_en_US.json");
            // Check if the inputStream is null
            if (inputStream2 != null) {

                BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));

                // Use Gson to parse the JSON data into objects
                Gson gson = new Gson();

                // Define the type of your data. For example, if your JSON represents a list of champions:

                Type listType2 = new TypeToken<List<Item>>() {
                }.getType();


                ListItems = gson.fromJson(reader2, listType2);
                // Now you have the extracted data in the championList
                // You can use it as needed
                // ...

                // Close the input stream
                inputStream2.close();
            } else {
                // Handle the case when the inputStream is null
                Log.e("JSON File", "Failed to open the JSON file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void GetDataItem() {
        int count = ListItems.size();
        for (int i = 0; i < count; i++) {

            String ItemImage = "items/" + ListItems.get(i).getId() + ".png";
            try {
                InputStream inputStream = getAssets().open(ItemImage);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                ListItemComp.add(new ItemCompUse(ListItems.get(i).getName(), ListItems.get(i).getDescription(), bitmap));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
