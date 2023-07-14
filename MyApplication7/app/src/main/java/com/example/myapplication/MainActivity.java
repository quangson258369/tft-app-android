package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.ChampionCompUse;
import com.example.myapplication.Models.ChampionDescription;
import com.example.myapplication.Models.Item;
import com.example.myapplication.Models.Suggestion;
import com.example.myapplication.Models.TeamComp;
import com.example.myapplication.adapter.Champion_Adapter;
import com.example.myapplication.adapter.Suggestion_Adapter;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DatabaseHelper myDB;
    Toolbar toolbar;
    RecyclerView rv;
    List<Champion> ListChampions = new ArrayList<>();
    List<Item> ListItems = new ArrayList<>();
    List<ChampionCompUse> ListChampionComp = new ArrayList<>();
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open_nav,R.string.close_nav);
        toggle.syncState();
        readJsonFile();
        //readDataChampionDes();
        //readDataTeamComp();
        getListChamp();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4,GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        Champion_Adapter championAdapter = new Champion_Adapter();
        championAdapter.setData(ListChampionComp);
        championAdapter.setOnItemClickListener(new Champion_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,ShowChampionDetail.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("champImage", ListChampionComp.get(position));
//                Log.e("ngu", ListChampions.get(position).getAbilityName());
//                bundle.putParcelable("champ", ListChampions.get(position));
                Log.d("day roi", ListChampions.get(position).getAttackrange()+"--"
                        +ListChampions.get(position).getAttackdamage()+"--"
                        +ListChampions.get(position).getMagicresist());
                intent.putExtra("champId", ListChampions.get(position).getId());
                intent.putExtra("champName", ListChampions.get(position).getName());
                intent.putExtra("champMana", ListChampions.get(position).getMana());
                intent.putExtra("champSynergySize", ListChampions.get(position).getClasses().size());
                for (int i=0;i<ListChampions.get(position).getClasses().size();i++){
                    intent.putExtra("champSynergy"+i, ListChampions.get(position).getClasses().get(i));
                }
                intent.putExtra("champItemSize", ListChampions.get(position).getItems().size());
                for (int i=0;i<ListChampions.get(position).getItems().size();i++){
                    intent.putExtra("champItem"+i, ListChampions.get(position).getItems().get(i));
                    Log.d("items","position="+position+"---"+ ListChampions.get(position).getItems().get(i));
                }
                intent.putExtra("champOrigin", ListChampions.get(position).getOrigin());
                intent.putExtra("champHealth", ListChampions.get(position).getHealth());
                intent.putExtra("champAttackSpeed", ListChampions.get(position).getAttackspeed());
                intent.putExtra("champAttackRange", ListChampions.get(position).getAttackrange());
                intent.putExtra("champInitMana", ListChampions.get(position).getStartingmana());
                intent.putExtra("champDps", ListChampions.get(position).getDps());
                intent.putExtra("champSkill", ListChampions.get(position).getAbilityName());
                intent.putExtra("champArmor", ListChampions.get(position).getArmor());
                intent.putExtra("champAttackDame", ListChampions.get(position).getAttackdamage());
                intent.putExtra("champMagicResist", ListChampions.get(position).getMagicresist());
                intent.putExtra("champSkillDes", ListChampions.get(position).getAbilitydescription());
                startActivity(intent);
            }
        });

        rv.setAdapter(championAdapter);
    }

    private void bindingView(){
        rv = findViewById(R.id.rclChamp);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }


    private void readJsonFile() {
        try {
            // Read the JSON file from the assets folder
            InputStream inputStream = getAssets().open("champions_en_US.json");
            InputStream inputStream2 = getAssets().open("items_en_US.json");
            // Check if the inputStream is null
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));

                // Use Gson to parse the JSON data into objects
                Gson gson = new Gson();

                // Define the type of your data. For example, if your JSON represents a list of champions:
                Type listType = new TypeToken<List<Champion>>() {
                }.getType();
                Type listType2 = new TypeToken<List<Item>>() {
                }.getType();
                // Parse the JSON data into a list of Champion objects
                List<Champion> championList = gson.fromJson(reader, listType);

                ListChampions = championList;

                ListItems = gson.fromJson(reader2, listType2);
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


    private void getListChamp(){
        for(int i =0;i<ListChampions.size();i++){
            String ChampionNameImage = "champions/" + ListChampions.get(i).getId() + ".png";
            try {
                InputStream inputStream = getAssets().open(ChampionNameImage);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Log.d("abcde", ListChampions.get(i).getName());
                ListChampionComp.add(new ChampionCompUse(ListChampions.get(i).getName(),bitmap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Bitmap GetItemByName(String name) {
        int count = ListItems.size();
        for (int i = 0; i < count; i++) {
            if (ListItems.get(i).getName().equals(name)) {
                String ItemImage = "items/" + ListItems.get(i).getId() + ".png";
                try {
                    InputStream inputStream = getAssets().open(ItemImage);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void AddChampionDescription(String name, String placeId) {
        ChampionDescription desc = new ChampionDescription();
        desc.setChampionName(name);
        desc.setChampionPlaceID(placeId);
        desc.setTeamCompID("");
        desc.setFirstItemName("");
        desc.setSecondItemName("");
        desc.setThirdItemName("");
    }
    public static final int nav_champion = 1000147;
    public static final int nav_item = 1000022;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case nav_champion:
                Toast.makeText(this,"Champion selected",Toast.LENGTH_SHORT).show();
                break;
            case nav_item:
                Toast.makeText(this,"Item selected",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}