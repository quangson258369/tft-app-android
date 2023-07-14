package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.Models.Augment;
import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.ChampionDescription;
import com.example.myapplication.Models.Item;
import com.example.myapplication.Models.Suggestion;
import com.example.myapplication.Models.TeamComp;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnAugments;
    public ImageView mImageView;
    public ImageView mImageView2;
    public ImageView mImageView3;
    public ImageView mImageView4;
    public ImageView mImageView5;
    public ImageView mImageView6;
    public ImageView mImageView7;
    public ImageView mImageView8;
    public ImageView mImageView9;
    public ImageView mImageView10;
    public ImageView mImageView11;
    public ImageView mImageView12;
    public ImageView mImageView13;
    public ImageView mImageView14;
    public ImageView mImageView15;
    public ImageView mImageView16;
    public ImageView mImageView17;
    public ImageView mImageView18;
    public ImageView mImageView19;
    public ImageView mImageView20;
    public ImageView mImageView21;
    public ImageView mImageView22;
    public ImageView mImageView23;
    public ImageView mImageView24;
    public ImageView mImageView25;
    public ImageView mImageView26;
    public ImageView mImageView27;
    public ImageView mImageView28;
    private SearchView searchView;
    private ImageView imgFirstItem;
    private ImageView imgSecondItem;
    private ImageView imgThirdItem;

    private ImageView imgFirstItem2;
    private ImageView imgSecondItem2;
    private ImageView imgThirdItem2;

    private ImageView imgFirstItem3;
    private ImageView imgSecondItem3;
    private ImageView imgThirdItem3;

    private ImageView imgFirstItem4;
    private ImageView imgSecondItem4;
    private ImageView imgThirdItem4;

    private ImageView imgFirstItem5;
    private ImageView imgSecondItem5;
    private ImageView imgThirdItem5;

    private ImageView imgFirstItem6;
    private ImageView imgSecondItem6;
    private ImageView imgThirdItem6;

    private ImageView imgFirstItem7;
    private ImageView imgSecondItem7;
    private ImageView imgThirdItem7;

    private ImageView imgFirstItem8;
    private ImageView imgSecondItem8;
    private ImageView imgThirdItem8;

    private ImageView imgFirstItem9;
    private ImageView imgSecondItem9;
    private ImageView imgThirdItem9;

    private ImageView imgFirstItem10;
    private ImageView imgSecondItem10;
    private ImageView imgThirdItem10;

    private ImageView imgFirstItem11;
    private ImageView imgSecondItem11;
    private ImageView imgThirdItem11;

    private ImageView imgFirstItem12;
    private ImageView imgSecondItem12;
    private ImageView imgThirdItem12;

    private ImageView imgFirstItem13;
    private ImageView imgSecondItem13;
    private ImageView imgThirdItem13;

    private ImageView imgFirstItem14;
    private ImageView imgSecondItem14;
    private ImageView imgThirdItem14;

    private ImageView imgFirstItem15;
    private ImageView imgSecondItem15;
    private ImageView imgThirdItem15;

    private ImageView imgFirstItem16;
    private ImageView imgSecondItem16;
    private ImageView imgThirdItem16;

    private ImageView imgFirstItem17;
    private ImageView imgSecondItem17;
    private ImageView imgThirdItem17;

    private ImageView imgFirstItem18;
    private ImageView imgSecondItem18;
    private ImageView imgThirdItem18;

    private ImageView imgFirstItem19;
    private ImageView imgSecondItem19;
    private ImageView imgThirdItem19;

    private ImageView imgFirstItem20;
    private ImageView imgSecondItem20;
    private ImageView imgThirdItem20;

    private ImageView imgFirstItem21;
    private ImageView imgSecondItem21;
    private ImageView imgThirdItem21;

    private ImageView imgFirstItem22;
    private ImageView imgSecondItem22;
    private ImageView imgThirdItem22;

    private ImageView imgFirstItem23;
    private ImageView imgSecondItem23;
    private ImageView imgThirdItem23;

    private ImageView imgFirstItem24;
    private ImageView imgSecondItem24;
    private ImageView imgThirdItem24;

    private ImageView imgFirstItem25;
    private ImageView imgSecondItem25;
    private ImageView imgThirdItem25;

    private ImageView imgFirstItem26;
    private ImageView imgSecondItem26;
    private ImageView imgThirdItem26;

    private ImageView imgFirstItem27;
    private ImageView imgSecondItem27;
    private ImageView imgThirdItem27;

    private ImageView imgFirstItem28;
    private ImageView imgSecondItem28;
    private ImageView imgThirdItem28;
    private int selectedImageViewId = 0;
    private static final long DOUBLE_CLICK_TIME_DELTA = 300;
    private boolean isSearchViewVisible = false;
    private long lastClickTime = 0;
    private List<TeamComp> teamCompList;
    private List<ChampionDescription> champDes;
    private TeamComp newTeamComposition = new TeamComp();
    private List<ChampionDescription> newTeamCompDesc = new ArrayList<ChampionDescription>();
    private DatabaseHelper myDB;
    private List<String> items = new ArrayList<String>();
    private EditText teamName;
    private Suggestion_Adapter Sadapter;
    private List<Suggestion> suggestions= new ArrayList<Suggestion>();
    private RecyclerView rcvlistView;
    private AutoCompleteTextView editTextView;

    private Button BtnAugments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAugments = findViewById(R.id.btnAugments);



        teamName = findViewById(R.id.TeamCompName);
        mImageView = findViewById(R.id.imageView);
        mImageView2 = findViewById(R.id.imageView2);
        mImageView3 = findViewById(R.id.imageView3);
        mImageView4 = findViewById(R.id.imageView4);
        mImageView5 = findViewById(R.id.imageView5);
        mImageView6 = findViewById(R.id.imageView6);
        mImageView7 = findViewById(R.id.imageView7);
        mImageView8 = findViewById(R.id.imageView8);
        mImageView9 = findViewById(R.id.imageView9);
        mImageView10 = findViewById(R.id.imageView10);
        mImageView11 = findViewById(R.id.imageView11);
        mImageView12 = findViewById(R.id.imageView12);
        mImageView13 = findViewById(R.id.imageView13);
        mImageView14 = findViewById(R.id.imageView14);
        mImageView15 = findViewById(R.id.imageView15);
        mImageView16 = findViewById(R.id.imageView16);
        mImageView17 = findViewById(R.id.imageView17);
        mImageView18 = findViewById(R.id.imageView18);
        mImageView19 = findViewById(R.id.imageView19);
        mImageView20 = findViewById(R.id.imageView20);
        mImageView21 = findViewById(R.id.imageView21);
        mImageView22 = findViewById(R.id.imageView22);
        mImageView23 = findViewById(R.id.imageView23);
        mImageView24 = findViewById(R.id.imageView24);
        mImageView25 = findViewById(R.id.imageView25);
        mImageView26 = findViewById(R.id.imageView26);
        mImageView27 = findViewById(R.id.imageView27);
        mImageView28 = findViewById(R.id.imageView28);


        imgFirstItem = findViewById(R.id.imgFirstItem);
        imgSecondItem = findViewById(R.id.imgSecondItem);
        imgThirdItem = findViewById(R.id.imgThirdItem);

        imgFirstItem2 = findViewById(R.id.imgFirstItem2);
        imgSecondItem2 = findViewById(R.id.imgSecondItem2);
        imgThirdItem2 = findViewById(R.id.imgThirdItem2);

        imgFirstItem3 = findViewById(R.id.imgFirstItem3);
        imgSecondItem3 = findViewById(R.id.imgSecondItem3);
        imgThirdItem3 = findViewById(R.id.imgThirdItem3);

        imgFirstItem4 = findViewById(R.id.imgFirstItem4);
        imgSecondItem4 = findViewById(R.id.imgSecondItem4);
        imgThirdItem4 = findViewById(R.id.imgThirdItem4);

        imgFirstItem5 = findViewById(R.id.imgFirstItem5);
        imgSecondItem5 = findViewById(R.id.imgSecondItem5);
        imgThirdItem5 = findViewById(R.id.imgThirdItem5);

        imgFirstItem6 = findViewById(R.id.imgFirstItem6);
        imgSecondItem6 = findViewById(R.id.imgSecondItem6);
        imgThirdItem6 = findViewById(R.id.imgThirdItem6);

        imgFirstItem7 = findViewById(R.id.imgFirstItem7);
        imgSecondItem7 = findViewById(R.id.imgSecondItem7);
        imgThirdItem7 = findViewById(R.id.imgThirdItem7);

        imgFirstItem8 = findViewById(R.id.imgFirstItem8);
        imgSecondItem8 = findViewById(R.id.imgSecondItem8);
        imgThirdItem8 = findViewById(R.id.imgThirdItem8);

        imgFirstItem9 = findViewById(R.id.imgFirstItem9);
        imgSecondItem9 = findViewById(R.id.imgSecondItem9);
        imgThirdItem9 = findViewById(R.id.imgThirdItem9);

        imgFirstItem10 = findViewById(R.id.imgFirstItem10);
        imgSecondItem10 = findViewById(R.id.imgSecondItem10);
        imgThirdItem10 = findViewById(R.id.imgThirdItem10);

        imgFirstItem11 = findViewById(R.id.imgFirstItem11);
        imgSecondItem11 = findViewById(R.id.imgSecondItem11);
        imgThirdItem11 = findViewById(R.id.imgThirdItem11);

        imgFirstItem12 = findViewById(R.id.imgFirstItem12);
        imgSecondItem12 = findViewById(R.id.imgSecondItem12);
        imgThirdItem12 = findViewById(R.id.imgThirdItem12);

        imgFirstItem13 = findViewById(R.id.imgFirstItem13);
        imgSecondItem13 = findViewById(R.id.imgSecondItem13);
        imgThirdItem13 = findViewById(R.id.imgThirdItem13);

        imgFirstItem14 = findViewById(R.id.imgFirstItem14);
        imgSecondItem14 = findViewById(R.id.imgSecondItem14);
        imgThirdItem14 = findViewById(R.id.imgThirdItem14);

        imgFirstItem15 = findViewById(R.id.imgFirstItem15);
        imgSecondItem15 = findViewById(R.id.imgSecondItem15);
        imgThirdItem15 = findViewById(R.id.imgThirdItem15);

        imgFirstItem16 = findViewById(R.id.imgFirstItem16);
        imgSecondItem16 = findViewById(R.id.imgSecondItem16);
        imgThirdItem16 = findViewById(R.id.imgThirdItem16);

        imgFirstItem17 = findViewById(R.id.imgFirstItem17);
        imgSecondItem17 = findViewById(R.id.imgSecondItem17);
        imgThirdItem17 = findViewById(R.id.imgThirdItem17);

        imgFirstItem18 = findViewById(R.id.imgFirstItem18);
        imgSecondItem18 = findViewById(R.id.imgSecondItem18);
        imgThirdItem18 = findViewById(R.id.imgThirdItem18);

        imgFirstItem19 = findViewById(R.id.imgFirstItem19);
        imgSecondItem19 = findViewById(R.id.imgSecondItem19);
        imgThirdItem19 = findViewById(R.id.imgThirdItem19);

        imgFirstItem20 = findViewById(R.id.imgFirstItem20);
        imgSecondItem20 = findViewById(R.id.imgSecondItem20);
        imgThirdItem20 = findViewById(R.id.imgThirdItem20);

        imgFirstItem21 = findViewById(R.id.imgFirstItem21);
        imgSecondItem21 = findViewById(R.id.imgSecondItem21);
        imgThirdItem21 = findViewById(R.id.imgThirdItem21);

        imgFirstItem22 = findViewById(R.id.imgFirstItem22);
        imgSecondItem22 = findViewById(R.id.imgSecondItem22);
        imgThirdItem22 = findViewById(R.id.imgThirdItem22);

        imgFirstItem23 = findViewById(R.id.imgFirstItem23);
        imgSecondItem23 = findViewById(R.id.imgSecondItem23);
        imgThirdItem23 = findViewById(R.id.imgThirdItem23);

        imgFirstItem24 = findViewById(R.id.imgFirstItem24);
        imgSecondItem24 = findViewById(R.id.imgSecondItem24);
        imgThirdItem24 = findViewById(R.id.imgThirdItem24);

        imgFirstItem25 = findViewById(R.id.imgFirstItem25);
        imgSecondItem25 = findViewById(R.id.imgSecondItem25);
        imgThirdItem25 = findViewById(R.id.imgThirdItem25);

        imgFirstItem26 = findViewById(R.id.imgFirstItem26);
        imgSecondItem26 = findViewById(R.id.imgSecondItem26);
        imgThirdItem26 = findViewById(R.id.imgThirdItem26);

        imgFirstItem27 = findViewById(R.id.imgFirstItem27);
        imgSecondItem27 = findViewById(R.id.imgSecondItem27);
        imgThirdItem27 = findViewById(R.id.imgThirdItem27);

        imgFirstItem28 = findViewById(R.id.imgFirstItem28);
        imgSecondItem28 = findViewById(R.id.imgSecondItem28);
        imgThirdItem28 = findViewById(R.id.imgThirdItem28);


        mImageView.setOnClickListener(this);
        mImageView2.setOnClickListener(this);
        mImageView3.setOnClickListener(this);
        mImageView4.setOnClickListener(this);
        mImageView5.setOnClickListener(this);
        mImageView6.setOnClickListener(this);
        mImageView7.setOnClickListener(this);
        mImageView8.setOnClickListener(this);
        mImageView9.setOnClickListener(this);
        mImageView10.setOnClickListener(this);
        mImageView11.setOnClickListener(this);
        mImageView12.setOnClickListener(this);
        mImageView13.setOnClickListener(this);
        mImageView14.setOnClickListener(this);
        mImageView15.setOnClickListener(this);
        mImageView16.setOnClickListener(this);
        mImageView17.setOnClickListener(this);
        mImageView18.setOnClickListener(this);
        mImageView19.setOnClickListener(this);
        mImageView20.setOnClickListener(this);
        mImageView21.setOnClickListener(this);
        mImageView22.setOnClickListener(this);
        mImageView23.setOnClickListener(this);
        mImageView24.setOnClickListener(this);
        mImageView25.setOnClickListener(this);
        mImageView26.setOnClickListener(this);
        mImageView27.setOnClickListener(this);
        mImageView28.setOnClickListener(this);


        teamCompList = new ArrayList<>();
        champDes = new ArrayList<>();
        myDB = new DatabaseHelper(MainActivity.this);
        readJsonFile();
        readDataChampionDes();
        readDataTeampComp();

        rcvlistView = findViewById(R.id.rcv_suggestion);
         editTextView = findViewById(R.id.searchText);
        editTextView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        editTextView.setSingleLine(true);

        BtnAugments = (Button) findViewById(R.id.btnAugments);

        BtnAugments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAugments();
            }
        });
    }

    private List<Augment> ListAugments = new ArrayList<>();


    public void openAugments(){
        Intent intent = new Intent(this, AugmentList.class);
        startActivity(intent);
    }

    private List<Champion> ListChampions= new ArrayList<>();
    private List<Item> ListItems= new ArrayList<>();

    private void readJsonFile() {
        try {
            // Read the JSON file from the assets folder
            InputStream inputStream = getAssets().open("champions_en_US.json");
            InputStream inputStream2 = getAssets().open("items_en_US.json");
            InputStream inputStream3 = getAssets().open("augments_en_US.json");
            // Check if the inputStream is null
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));
                BufferedReader reader3 = new BufferedReader(new InputStreamReader(inputStream3));

                // Use Gson to parse the JSON data into objects
                Gson gson = new Gson();

                // Define the type of your data. For example, if your JSON represents a list of champions:
                Type listType = new TypeToken<List<Champion>>() {
                }.getType();
                Type listType2 = new TypeToken<List<Item>>() {
                }.getType();

                Type listType3 = new TypeToken<List<Augment>>() {
                }.getType();

                // Parse the JSON data into a list of Champion objects
                List<Champion> championList = gson.fromJson(reader, listType);

                ListChampions = championList;

                ListItems = gson.fromJson(reader2, listType2);

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

    private void readDataTeampComp() {
        Cursor cursor = myDB.readTeamCompData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                String nameOfTeamComp = cursor.getString(1);
                TeamComp team = new TeamComp(id, nameOfTeamComp);
                teamCompList.add(team);
            }
        }
    }

    private void readDataChampionDes() {
        Cursor cursor = myDB.readChampionDesData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                String teamCompId = cursor.getString(0);
                String ChampName = cursor.getString(1);
                String ChampionPlaceID = cursor.getString(2);
                String FirstItemName = cursor.getString(3);
                String SecondItemName = cursor.getString(4);
                String ThirdItemName = cursor.getString(5);
                ChampionDescription description =
                        new ChampionDescription(teamCompId, ChampName, ChampionPlaceID, FirstItemName, SecondItemName, ThirdItemName);
                champDes.add(description);
            }
        }
    }

    private Bitmap GetChampionImageByName(String name) {
        int count = ListChampions.size();
        for (int i = 0; i < count; i++) {
            if (ListChampions.get(i).getName().equals(name)) {
                String ChampionNameImage = "champions/" + ListChampions.get(i).getId() + ".png";
                try {
                    InputStream inputStream = getAssets().open(ChampionNameImage);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
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
        newTeamCompDesc.add(desc);
    }


    public void AddItemEachChampionDescription(String itemName, String placeID) {
        for (int i = 0; i < newTeamCompDesc.size(); i++) {
            if (newTeamCompDesc.get(i).getChampionPlaceID() == placeID) {
                if (newTeamCompDesc.get(i).getFirstItemName() == "") {
                    newTeamCompDesc.get(i).setFirstItemName(itemName);
                } else if (newTeamCompDesc.get(i).getFirstItemName() != "") {
                    newTeamCompDesc.get(i).setSecondItemName(itemName);
                } else if (newTeamCompDesc.get(i).getFirstItemName() != "" && newTeamCompDesc.get(i).getSecondItemName() != "") {
                    newTeamCompDesc.get(i).setThirdItemName(itemName);
                }
            }
        }
    }


    public void RemoveChampionDescription(String placeId) {
        for (int i = 0; i < newTeamCompDesc.size(); i++) {
            if (newTeamCompDesc.get(i).getChampionPlaceID().equals(placeId)) {
                newTeamCompDesc.remove(i);
            }
        }
    }

    public void onClick(View v) {
        long clickTime = System.currentTimeMillis();
        int viewId = v.getId();

        // Check if the clicked view is one of the specified ImageView elements
        boolean isImageView = (viewId == R.id.imageView || viewId == R.id.imageView2
                || viewId == R.id.imageView3 || viewId == R.id.imageView4
                || viewId == R.id.imageView5 || viewId == R.id.imageView6
                || viewId == R.id.imageView7 || viewId == R.id.imageView8
                || viewId == R.id.imageView9 || viewId == R.id.imageView10
                || viewId == R.id.imageView11 || viewId == R.id.imageView12
                || viewId == R.id.imageView13 || viewId == R.id.imageView14
                || viewId == R.id.imageView15 || viewId == R.id.imageView16
                || viewId == R.id.imageView17 || viewId == R.id.imageView18
                || viewId == R.id.imageView19 || viewId == R.id.imageView20
                || viewId == R.id.imageView21 || viewId == R.id.imageView22
                || viewId == R.id.imageView23 || viewId == R.id.imageView24
                || viewId == R.id.imageView25 || viewId == R.id.imageView26
                || viewId == R.id.imageView27 || viewId == R.id.imageView28);

        if (isImageView) {
            // Double-click detection
            if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                // Double click occurred, make the searchView GONE
                selectedImageViewId = viewId;
                editTextView.setVisibility(View.GONE);
                performSearch("");

            }

            lastClickTime = clickTime;

            selectedImageViewId = viewId;
            boolean check= isCHampion(selectedImageViewId);
            if(check) {
                conditionFilter(ListChampions,ListItems,"champion");
            }
            else{
                conditionFilter(ListChampions,ListItems,"item");
            }
            editTextView.setVisibility(View.VISIBLE);

            editTextView.setOnEditorActionListener((textView, actionId, event) ->
                    {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                            performSearch(textView.getText().toString());

                            return true;
                        }
                        editTextView.setText("");

                        editTextView.setVisibility(View.GONE);
                        return false;
                    }
                    );

        }

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    long touchTime = System.currentTimeMillis();
                    // Check if the touched view is not one of the specified ImageView elements
                    if (v.getId() != R.id.imageView && v.getId() != R.id.imageView2
                            && v.getId() != R.id.imageView3 && v.getId() != R.id.imageView4
                            && v.getId() != R.id.imageView5 && v.getId() != R.id.imageView6
                            && v.getId() != R.id.imageView7 && v.getId() != R.id.imageView8
                            && v.getId() != R.id.imageView9 && v.getId() != R.id.imageView10
                            && v.getId() != R.id.imageView11 && v.getId() != R.id.imageView12
                            && v.getId() != R.id.imageView13 && v.getId() != R.id.imageView14
                            && v.getId() != R.id.imageView15 && v.getId() != R.id.imageView16
                            && v.getId() != R.id.imageView17 && v.getId() != R.id.imageView18
                            && v.getId() != R.id.imageView19 && v.getId() != R.id.imageView20
                            && v.getId() != R.id.imageView21 && v.getId() != R.id.imageView22
                            && v.getId() != R.id.imageView23 && v.getId() != R.id.imageView24
                            && v.getId() != R.id.imageView25 && v.getId() != R.id.imageView26
                            // ... add the remaining image view IDs here ...
                            && v.getId() != R.id.imageView27 && v.getId() != R.id.imageView28) {
                        editTextView.setVisibility(View.GONE);

                    }

                }
                return false;
            }
        });
    }

    public void conditionFilter(List<Champion>championList,List<Item>itemList,String type){
        List<Suggestion>suggestionList = new ArrayList<Suggestion>();
       if(type.equals("champion")){
          for(Champion item : championList){

           Bitmap championImg= GetChampionImageByName(item.getName());
           Suggestion suggestion = new Suggestion(championImg,item.getName());
           suggestionList.add(suggestion);
          }
       }
       else{
           for(Item item : itemList){
               if(item.getEffects().size() > 0){
                   Bitmap itemImg=GetItemByName(item.getName());
                   Suggestion suggestion = new Suggestion(itemImg,item.getName());
                   suggestionList.add(suggestion);
               }

           }
       }
       Suggestion_Adapter adapter = new Suggestion_Adapter(this,suggestionList);
       editTextView.setAdapter(adapter);
    }
    public boolean isCHampion(int id) {
        ImageView chamionImg=findViewById(id);
        Drawable chamimg= chamionImg.getDrawable();
        Drawable imgDefault = getDrawable(R.drawable.none);
        if(chamimg.getConstantState().equals(imgDefault.getConstantState())){
            return true;
        }
        return false;
    }


    private void performSearch(String query) {

        String search = "tft8_" + query;


        if (selectedImageViewId == R.id.imageView) {
            if (query == "") {
                imgFirstItem.setVisibility(View.GONE);
                imgFirstItem.setImageResource(R.drawable.none);
                imgSecondItem.setVisibility(View.GONE);
                imgSecondItem.setImageResource(R.drawable.none);
                imgThirdItem.setVisibility(View.GONE);
                imgThirdItem.setImageResource(R.drawable.none);
                mImageView.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem.getDrawable();
            Drawable itemSecond = imgSecondItem.getDrawable();
            Drawable itemLast = imgThirdItem.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {

                    mImageView.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView");

                } else {
                    mImageView.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem.setVisibility(View.VISIBLE);
                    imgFirstItem.setImageBitmap(bitmapFirstItems);
                    AddItemEachChampionDescription(query, "imageView");

                } else {
                    imgFirstItem.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem.setVisibility(View.VISIBLE);
                    imgSecondItem.setImageBitmap(bitmapSecondItems);
                    AddItemEachChampionDescription(query, "imageView");

                } else {
                    imgSecondItem.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem.setVisibility(View.VISIBLE);
                    imgThirdItem.setImageBitmap(bitmapThirdItems);
                    AddItemEachChampionDescription(query, "imageView");

                } else {
                    imgThirdItem.setImageResource(R.drawable.none);

                }
            }
            // Change image for imageView1 based on search query

        } else if (selectedImageViewId == R.id.imageView2) {
            if (query == "") {
                imgFirstItem2.setVisibility(View.GONE);
                imgFirstItem2.setImageResource(R.drawable.none);
                imgSecondItem2.setVisibility(View.GONE);
                imgSecondItem2.setImageResource(R.drawable.none);
                imgThirdItem2.setVisibility(View.GONE);
                imgThirdItem2.setImageResource(R.drawable.none);
                mImageView2.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView2.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem2.getDrawable();
            Drawable itemSecond = imgSecondItem2.getDrawable();
            Drawable itemLast = imgThirdItem2.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView2.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView2");
                } else {
                    mImageView2.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView2");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem2.setImageBitmap(bitmapFirstItems);
                    imgFirstItem2.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView2");
                } else {
                    imgFirstItem2.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem2.setImageBitmap(bitmapSecondItems);
                    imgSecondItem2.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView2");
                } else {
                    imgSecondItem2.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem2.setImageBitmap(bitmapThirdItems);
                    imgThirdItem2.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView2");
                } else {
                    imgThirdItem2.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView3) {
            if (query == "") {
                imgFirstItem3.setVisibility(View.GONE);
                imgFirstItem3.setImageResource(R.drawable.none);
                imgSecondItem3.setVisibility(View.GONE);
                imgSecondItem3.setImageResource(R.drawable.none);
                imgThirdItem3.setVisibility(View.GONE);
                imgThirdItem3.setImageResource(R.drawable.none);
                mImageView3.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView3.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem3.getDrawable();
            Drawable itemSecond = imgSecondItem3.getDrawable();
            Drawable itemLast = imgThirdItem3.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView3.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView3");
                } else {
                    mImageView3.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView3");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem3.setImageBitmap(bitmapFirstItems);
                    imgFirstItem3.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView3");
                } else {
                    imgFirstItem3.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem3.setImageBitmap(bitmapSecondItems);
                    imgSecondItem3.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView3");
                } else {
                    imgSecondItem3.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem3.setImageBitmap(bitmapThirdItems);
                    imgThirdItem3.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView3");
                } else {
                    imgThirdItem3.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView4) {
            if (query == "") {
                imgFirstItem4.setVisibility(View.GONE);
                imgFirstItem4.setImageResource(R.drawable.none);
                imgSecondItem4.setVisibility(View.GONE);
                imgSecondItem4.setImageResource(R.drawable.none);
                imgThirdItem4.setVisibility(View.GONE);
                imgThirdItem4.setImageResource(R.drawable.none);
                mImageView4.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView4.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem4.getDrawable();
            Drawable itemSecond = imgSecondItem4.getDrawable();
            Drawable itemLast = imgThirdItem4.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView4.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView4");
                } else {
                    mImageView4.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView4");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem4.setImageBitmap(bitmapFirstItems);
                    imgFirstItem4.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView4");
                } else {
                    imgFirstItem4.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem4.setImageBitmap(bitmapSecondItems);
                    imgSecondItem4.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView4");
                } else {
                    imgSecondItem4.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem4.setImageBitmap(bitmapThirdItems);
                    imgThirdItem4.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView4");
                } else {
                    imgThirdItem4.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView5) {
            if (query == "") {
                imgFirstItem5.setVisibility(View.GONE);
                imgFirstItem5.setImageResource(R.drawable.none);
                imgSecondItem5.setVisibility(View.GONE);
                imgSecondItem5.setImageResource(R.drawable.none);
                imgThirdItem5.setVisibility(View.GONE);
                imgThirdItem5.setImageResource(R.drawable.none);
                mImageView5.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView5.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem5.getDrawable();
            Drawable itemSecond = imgSecondItem5.getDrawable();
            Drawable itemLast = imgThirdItem5.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView5.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView5");
                } else {
                    mImageView5.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView5");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem5.setImageBitmap(bitmapFirstItems);
                    imgFirstItem5.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView5");
                } else {
                    imgFirstItem5.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem5.setImageBitmap(bitmapSecondItems);
                    imgSecondItem5.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView5");
                } else {
                    imgSecondItem5.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem5.setImageBitmap(bitmapThirdItems);
                    imgThirdItem5.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView5");
                } else {
                    imgThirdItem5.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView6) {
            if (query == "") {
                imgFirstItem6.setVisibility(View.GONE);
                imgFirstItem6.setImageResource(R.drawable.none);
                imgSecondItem6.setVisibility(View.GONE);
                imgSecondItem6.setImageResource(R.drawable.none);
                imgThirdItem6.setVisibility(View.GONE);
                imgThirdItem6.setImageResource(R.drawable.none);
                mImageView6.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView6.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem6.getDrawable();
            Drawable itemSecond = imgSecondItem6.getDrawable();
            Drawable itemLast = imgThirdItem6.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView6.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView6");
                } else {
                    mImageView6.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView6");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem6.setImageBitmap(bitmapFirstItems);
                    imgFirstItem6.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView6");
                } else {
                    imgFirstItem6.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem6.setImageBitmap(bitmapSecondItems);
                    imgSecondItem6.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView6");
                } else {
                    imgSecondItem6.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem6.setImageBitmap(bitmapThirdItems);
                    imgThirdItem6.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView6");
                } else {
                    imgThirdItem6.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView7) {
            if (query == "") {
                imgFirstItem7.setVisibility(View.GONE);
                imgFirstItem7.setImageResource(R.drawable.none);
                imgSecondItem7.setVisibility(View.GONE);
                imgSecondItem7.setImageResource(R.drawable.none);
                imgThirdItem7.setVisibility(View.GONE);
                imgThirdItem7.setImageResource(R.drawable.none);
                mImageView7.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView7.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem7.getDrawable();
            Drawable itemSecond = imgSecondItem7.getDrawable();
            Drawable itemLast = imgThirdItem7.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView7.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView7");
                } else {
                    mImageView7.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView7");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem7.setImageBitmap(bitmapFirstItems);
                    imgFirstItem7.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView7");
                } else {
                    imgFirstItem7.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem7.setImageBitmap(bitmapSecondItems);
                    imgSecondItem7.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView7");
                } else {
                    imgSecondItem7.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem7.setImageBitmap(bitmapThirdItems);
                    imgThirdItem7.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView7");
                } else {
                    imgThirdItem7.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView8) {
            if (query == "") {
                imgFirstItem8.setVisibility(View.GONE);
                imgFirstItem8.setImageResource(R.drawable.none);
                imgSecondItem8.setVisibility(View.GONE);
                imgSecondItem8.setImageResource(R.drawable.none);
                imgThirdItem8.setVisibility(View.GONE);
                imgThirdItem8.setImageResource(R.drawable.none);
                mImageView8.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView8.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem8.getDrawable();
            Drawable itemSecond = imgSecondItem8.getDrawable();
            Drawable itemLast = imgThirdItem8.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView8.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView8");
                } else {
                    mImageView8.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView8");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem8.setImageBitmap(bitmapFirstItems);
                    imgFirstItem8.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView8");
                } else {
                    imgFirstItem8.setImageResource(R.drawable.none);
                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem8.setImageBitmap(bitmapSecondItems);
                    imgSecondItem8.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView8");
                } else {
                    imgSecondItem8.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem8.setImageBitmap(bitmapThirdItems);
                    imgThirdItem8.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView8");
                } else {
                    imgThirdItem8.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView9) {
            if (query == "") {
                imgFirstItem9.setVisibility(View.GONE);
                imgFirstItem9.setImageResource(R.drawable.none);
                imgSecondItem9.setVisibility(View.GONE);
                imgSecondItem9.setImageResource(R.drawable.none);
                imgThirdItem9.setVisibility(View.GONE);
                imgThirdItem9.setImageResource(R.drawable.none);
                mImageView9.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView9.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem9.getDrawable();
            Drawable itemSecond = imgSecondItem9.getDrawable();
            Drawable itemLast = imgThirdItem9.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView9.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView9");
                } else {
                    mImageView9.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView9");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem9.setImageBitmap(bitmapFirstItems);
                    imgFirstItem9.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView9");
                } else {
                    imgFirstItem9.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem9.setImageBitmap(bitmapSecondItems);
                    imgSecondItem9.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView9");
                } else {
                    imgSecondItem9.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem9.setImageBitmap(bitmapThirdItems);
                    imgThirdItem9.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView9");

                } else {
                    imgThirdItem9.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView10) {
            if (query == "") {
                imgFirstItem10.setVisibility(View.GONE);
                imgFirstItem10.setImageResource(R.drawable.none);
                imgSecondItem10.setVisibility(View.GONE);
                imgSecondItem10.setImageResource(R.drawable.none);
                imgThirdItem10.setVisibility(View.GONE);
                imgThirdItem10.setImageResource(R.drawable.none);
                mImageView10.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView10.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem10.getDrawable();
            Drawable itemSecond = imgSecondItem10.getDrawable();
            Drawable itemLast = imgThirdItem10.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView10.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView10");
                } else {
                    mImageView10.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView10");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem10.setImageBitmap(bitmapFirstItems);
                    imgFirstItem10.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView10");
                } else {
                    imgFirstItem10.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem10.setImageBitmap(bitmapSecondItems);
                    imgSecondItem10.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView10");
                } else {
                    imgSecondItem10.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem10.setImageBitmap(bitmapThirdItems);
                    imgThirdItem10.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView10");
                } else {
                    imgThirdItem10.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView11) {
            if (query == "") {
                imgFirstItem11.setVisibility(View.GONE);
                imgFirstItem11.setImageResource(R.drawable.none);
                imgSecondItem11.setVisibility(View.GONE);
                imgSecondItem11.setImageResource(R.drawable.none);
                imgThirdItem11.setVisibility(View.GONE);
                imgThirdItem11.setImageResource(R.drawable.none);
                mImageView11.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView11.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem11.getDrawable();
            Drawable itemSecond = imgSecondItem11.getDrawable();
            Drawable itemLast = imgThirdItem11.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView11.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView11");
                } else {
                    mImageView11.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView11");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem11.setImageBitmap(bitmapFirstItems);
                    imgFirstItem11.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView11");
                } else {
                    imgFirstItem11.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem11.setImageBitmap(bitmapSecondItems);
                    imgSecondItem11.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView11");
                } else {
                    imgSecondItem11.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem11.setImageBitmap(bitmapThirdItems);
                    imgThirdItem11.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView11");
                } else {
                    imgThirdItem11.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView12) {
            if (query == "") {
                imgFirstItem12.setVisibility(View.GONE);
                imgFirstItem12.setImageResource(R.drawable.none);
                imgSecondItem12.setVisibility(View.GONE);
                imgSecondItem12.setImageResource(R.drawable.none);
                imgThirdItem12.setVisibility(View.GONE);
                imgThirdItem12.setImageResource(R.drawable.none);
                mImageView12.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView12.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem12.getDrawable();
            Drawable itemSecond = imgSecondItem12.getDrawable();
            Drawable itemLast = imgThirdItem12.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView12.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView12");
                } else {
                    mImageView12.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView12");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem12.setImageBitmap(bitmapFirstItems);
                    imgFirstItem12.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView12");
                } else {
                    imgFirstItem12.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem12.setImageBitmap(bitmapSecondItems);
                    imgSecondItem12.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView12");
                } else {
                    imgSecondItem12.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem12.setImageBitmap(bitmapThirdItems);
                    imgThirdItem12.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView12");
                } else {
                    imgThirdItem12.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView13) {
            if (query == "") {
                imgFirstItem13.setVisibility(View.GONE);
                imgFirstItem13.setImageResource(R.drawable.none);
                imgSecondItem13.setVisibility(View.GONE);
                imgSecondItem13.setImageResource(R.drawable.none);
                imgThirdItem13.setVisibility(View.GONE);
                imgThirdItem13.setImageResource(R.drawable.none);
                mImageView13.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView13.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem13.getDrawable();
            Drawable itemSecond = imgSecondItem13.getDrawable();
            Drawable itemLast = imgThirdItem13.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView13.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView13");
                } else {
                    mImageView13.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView13");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem13.setImageBitmap(bitmapFirstItems);
                    imgFirstItem13.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView13");
                } else {
                    imgFirstItem13.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem13.setImageBitmap(bitmapSecondItems);
                    imgSecondItem13.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView13");
                } else {
                    imgSecondItem13.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem13.setImageBitmap(bitmapThirdItems);
                    imgThirdItem13.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView13");
                } else {
                    imgThirdItem13.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView14) {
            if (query == "") {
                imgFirstItem14.setVisibility(View.GONE);
                imgFirstItem14.setImageResource(R.drawable.none);
                imgSecondItem14.setVisibility(View.GONE);
                imgSecondItem14.setImageResource(R.drawable.none);
                imgThirdItem14.setVisibility(View.GONE);
                imgThirdItem14.setImageResource(R.drawable.none);
                mImageView14.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView14.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem14.getDrawable();
            Drawable itemSecond = imgSecondItem14.getDrawable();
            Drawable itemLast = imgThirdItem14.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView14.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView14");
                } else {
                    mImageView14.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView14");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem14.setImageBitmap(bitmapFirstItems);
                    imgFirstItem14.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView14");
                } else {
                    imgFirstItem14.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem14.setImageBitmap(bitmapSecondItems);
                    imgSecondItem14.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView14");
                } else {
                    imgSecondItem14.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem14.setImageBitmap(bitmapThirdItems);
                    imgThirdItem14.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView14");
                } else {
                    imgThirdItem14.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView15) {
            if (query == "") {
                imgFirstItem15.setVisibility(View.GONE);
                imgFirstItem15.setImageResource(R.drawable.none);
                imgSecondItem15.setVisibility(View.GONE);
                imgSecondItem15.setImageResource(R.drawable.none);
                imgThirdItem15.setVisibility(View.GONE);
                imgThirdItem15.setImageResource(R.drawable.none);
                mImageView15.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView15.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem15.getDrawable();
            Drawable itemSecond = imgSecondItem15.getDrawable();
            Drawable itemLast = imgThirdItem15.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView15.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView15");
                } else {
                    mImageView15.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView15");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem15.setImageBitmap(bitmapFirstItems);
                    imgFirstItem15.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView15");
                } else {
                    imgFirstItem15.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem15.setImageBitmap(bitmapSecondItems);
                    imgSecondItem15.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView15");
                } else {
                    imgSecondItem15.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem15.setImageBitmap(bitmapThirdItems);
                    imgThirdItem15.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView15");
                } else {
                    imgThirdItem15.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView16) {
            if (query == "") {
                imgFirstItem16.setVisibility(View.GONE);
                imgFirstItem16.setImageResource(R.drawable.none);
                imgSecondItem16.setVisibility(View.GONE);
                imgSecondItem16.setImageResource(R.drawable.none);
                imgThirdItem16.setVisibility(View.GONE);
                imgThirdItem16.setImageResource(R.drawable.none);
                mImageView16.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView16.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem16.getDrawable();
            Drawable itemSecond = imgSecondItem16.getDrawable();
            Drawable itemLast = imgThirdItem16.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView16.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView16");
                } else {
                    mImageView16.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView16");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem16.setImageBitmap(bitmapFirstItems);
                    imgFirstItem16.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView16");
                } else {
                    imgFirstItem16.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem16.setImageBitmap(bitmapSecondItems);
                    imgSecondItem16.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView16");
                } else {
                    imgSecondItem16.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem16.setImageBitmap(bitmapThirdItems);
                    imgThirdItem16.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView16");
                } else {
                    imgThirdItem16.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView17) {
            if (query == "") {
                imgFirstItem17.setVisibility(View.GONE);
                imgFirstItem17.setImageResource(R.drawable.none);
                imgSecondItem17.setVisibility(View.GONE);
                imgSecondItem17.setImageResource(R.drawable.none);
                imgThirdItem17.setVisibility(View.GONE);
                imgThirdItem17.setImageResource(R.drawable.none);
                mImageView17.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView17.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem17.getDrawable();
            Drawable itemSecond = imgSecondItem17.getDrawable();
            Drawable itemLast = imgThirdItem17.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView17.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView17");
                } else {
                    mImageView17.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView17");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem17.setImageBitmap(bitmapFirstItems);
                    imgFirstItem17.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView17");
                } else {
                    imgFirstItem17.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem17.setImageBitmap(bitmapSecondItems);
                    imgSecondItem17.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView17");
                } else {
                    imgSecondItem17.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem17.setImageBitmap(bitmapThirdItems);
                    imgThirdItem17.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView17");
                } else {
                    imgThirdItem17.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView18) {
            if (query == "") {
                imgFirstItem18.setVisibility(View.GONE);
                imgFirstItem18.setImageResource(R.drawable.none);
                imgSecondItem18.setVisibility(View.GONE);
                imgSecondItem18.setImageResource(R.drawable.none);
                imgThirdItem18.setVisibility(View.GONE);
                imgThirdItem18.setImageResource(R.drawable.none);
                mImageView18.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView18.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem18.getDrawable();
            Drawable itemSecond = imgSecondItem18.getDrawable();
            Drawable itemLast = imgThirdItem18.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView18.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView18");
                } else {
                    mImageView18.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView18");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem18.setImageBitmap(bitmapFirstItems);
                    imgFirstItem18.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView18");
                } else {
                    imgFirstItem18.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem18.setImageBitmap(bitmapSecondItems);
                    imgSecondItem18.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView18");
                } else {
                    imgSecondItem18.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem18.setImageBitmap(bitmapThirdItems);
                    imgThirdItem18.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView18");
                } else {
                    imgThirdItem18.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView19) {
            if (query == "") {
                imgFirstItem19.setVisibility(View.GONE);
                imgFirstItem19.setImageResource(R.drawable.none);
                imgSecondItem19.setVisibility(View.GONE);
                imgSecondItem19.setImageResource(R.drawable.none);
                imgThirdItem19.setVisibility(View.GONE);
                imgThirdItem19.setImageResource(R.drawable.none);
                mImageView19.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView19.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem19.getDrawable();
            Drawable itemSecond = imgSecondItem19.getDrawable();
            Drawable itemLast = imgThirdItem19.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView19.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView19");
                } else {
                    mImageView19.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView19");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem19.setImageBitmap(bitmapFirstItems);
                    imgFirstItem19.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView19");
                } else {
                    imgFirstItem19.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem19.setImageBitmap(bitmapSecondItems);
                    imgSecondItem19.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView19");
                } else {
                    imgSecondItem19.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem19.setImageBitmap(bitmapThirdItems);
                    imgThirdItem19.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView19");
                } else {
                    imgThirdItem19.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView20) {
            if (query == "") {
                imgFirstItem20.setVisibility(View.GONE);
                imgFirstItem20.setImageResource(R.drawable.none);
                imgSecondItem20.setVisibility(View.GONE);
                imgSecondItem20.setImageResource(R.drawable.none);
                imgThirdItem20.setVisibility(View.GONE);
                imgThirdItem20.setImageResource(R.drawable.none);
                mImageView20.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView20.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem20.getDrawable();
            Drawable itemSecond = imgSecondItem20.getDrawable();
            Drawable itemLast = imgThirdItem20.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView20.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView20");
                } else {
                    mImageView20.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView20");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem20.setImageBitmap(bitmapFirstItems);
                    imgFirstItem20.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView20");
                } else {
                    imgFirstItem20.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem20.setImageBitmap(bitmapSecondItems);
                    imgSecondItem20.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView20");
                } else {
                    imgSecondItem20.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem20.setImageBitmap(bitmapThirdItems);
                    imgThirdItem20.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView20");
                } else {
                    imgThirdItem20.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView21) {
            if (query == "") {
                imgFirstItem21.setVisibility(View.GONE);
                imgFirstItem21.setImageResource(R.drawable.none);
                imgSecondItem21.setVisibility(View.GONE);
                imgSecondItem21.setImageResource(R.drawable.none);
                imgThirdItem21.setVisibility(View.GONE);
                imgThirdItem21.setImageResource(R.drawable.none);
                mImageView21.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView21.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem21.getDrawable();
            Drawable itemSecond = imgSecondItem21.getDrawable();
            Drawable itemLast = imgThirdItem21.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView21.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView21");
                } else {
                    mImageView21.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView21");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem21.setImageBitmap(bitmapFirstItems);
                    imgFirstItem21.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView21");
                } else {
                    imgFirstItem21.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem21.setImageBitmap(bitmapSecondItems);
                    imgSecondItem21.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView21");
                } else {
                    imgSecondItem21.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem21.setImageBitmap(bitmapThirdItems);
                    imgThirdItem21.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView21");
                } else {
                    imgThirdItem21.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView22) {
            if (query == "") {
                imgFirstItem22.setVisibility(View.GONE);
                imgFirstItem22.setImageResource(R.drawable.none);
                imgSecondItem22.setVisibility(View.GONE);
                imgSecondItem22.setImageResource(R.drawable.none);
                imgThirdItem22.setVisibility(View.GONE);
                imgThirdItem22.setImageResource(R.drawable.none);
                mImageView22.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView22.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem22.getDrawable();
            Drawable itemSecond = imgSecondItem22.getDrawable();
            Drawable itemLast = imgThirdItem22.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView22.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView22");
                } else {
                    mImageView22.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView22");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem22.setImageBitmap(bitmapFirstItems);
                    imgFirstItem22.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView22");
                } else {
                    imgFirstItem22.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem22.setImageBitmap(bitmapSecondItems);
                    imgSecondItem22.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView22");
                } else {
                    imgSecondItem22.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem22.setImageBitmap(bitmapThirdItems);
                    imgThirdItem22.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView22");
                } else {
                    imgThirdItem22.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView23) {
            if (query == "") {
                imgFirstItem23.setVisibility(View.GONE);
                imgFirstItem23.setImageResource(R.drawable.none);
                imgSecondItem23.setVisibility(View.GONE);
                imgSecondItem23.setImageResource(R.drawable.none);
                imgThirdItem23.setVisibility(View.GONE);
                imgThirdItem23.setImageResource(R.drawable.none);
                mImageView23.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView23.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem23.getDrawable();
            Drawable itemSecond = imgSecondItem23.getDrawable();
            Drawable itemLast = imgThirdItem23.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView23.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView23");
                } else {
                    mImageView23.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView23");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem23.setImageBitmap(bitmapFirstItems);
                    imgFirstItem23.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView23");
                } else {
                    imgFirstItem23.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem23.setImageBitmap(bitmapSecondItems);
                    imgSecondItem23.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView23");
                } else {
                    imgSecondItem23.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem23.setImageBitmap(bitmapThirdItems);
                    imgThirdItem23.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView23");
                } else {
                    imgThirdItem23.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView24) {
            if (query == "") {
                imgFirstItem24.setVisibility(View.GONE);
                imgFirstItem24.setImageResource(R.drawable.none);
                imgSecondItem24.setVisibility(View.GONE);
                imgSecondItem24.setImageResource(R.drawable.none);
                imgThirdItem24.setVisibility(View.GONE);
                imgThirdItem24.setImageResource(R.drawable.none);
                mImageView24.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView24.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem24.getDrawable();
            Drawable itemSecond = imgSecondItem24.getDrawable();
            Drawable itemLast = imgThirdItem24.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView24.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView24");
                } else {
                    mImageView24.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView24");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem24.setImageBitmap(bitmapFirstItems);
                    imgFirstItem24.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView24");
                } else {
                    imgFirstItem24.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem24.setImageBitmap(bitmapSecondItems);
                    imgSecondItem24.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView24");
                } else {
                    imgSecondItem24.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem24.setImageBitmap(bitmapThirdItems);
                    imgThirdItem24.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView24");
                } else {
                    imgThirdItem24.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView25) {
            if (query == "") {
                imgFirstItem25.setVisibility(View.GONE);
                imgFirstItem25.setImageResource(R.drawable.none);
                imgSecondItem25.setVisibility(View.GONE);
                imgSecondItem25.setImageResource(R.drawable.none);
                imgThirdItem25.setVisibility(View.GONE);
                imgThirdItem25.setImageResource(R.drawable.none);
                mImageView25.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView25.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem25.getDrawable();
            Drawable itemSecond = imgSecondItem25.getDrawable();
            Drawable itemLast = imgThirdItem25.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView25.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView25");
                } else {
                    mImageView25.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView25");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem25.setImageBitmap(bitmapFirstItems);
                    imgFirstItem25.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView25");
                } else {
                    imgFirstItem25.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem25.setImageBitmap(bitmapSecondItems);
                    imgSecondItem25.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView25");
                } else {
                    imgSecondItem25.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem25.setImageBitmap(bitmapThirdItems);
                    imgThirdItem25.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView25");
                } else {
                    imgThirdItem25.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView26) {
            if (query == "") {
                imgFirstItem26.setVisibility(View.GONE);
                imgFirstItem26.setImageResource(R.drawable.none);
                imgSecondItem26.setVisibility(View.GONE);
                imgSecondItem26.setImageResource(R.drawable.none);
                imgThirdItem26.setVisibility(View.GONE);
                imgThirdItem26.setImageResource(R.drawable.none);
                mImageView26.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView26.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem26.getDrawable();
            Drawable itemSecond = imgSecondItem26.getDrawable();
            Drawable itemLast = imgThirdItem26.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView26.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView26");
                } else {
                    mImageView26.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView26");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem26.setImageBitmap(bitmapFirstItems);
                    imgFirstItem26.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView26");
                } else {
                    imgFirstItem26.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem26.setImageBitmap(bitmapSecondItems);
                    imgSecondItem26.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView26");
                } else {
                    imgSecondItem26.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem26.setImageBitmap(bitmapThirdItems);
                    imgThirdItem26.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView26");
                } else {
                    imgThirdItem26.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView27) {
            if (query == "") {
                imgFirstItem27.setVisibility(View.GONE);
                imgFirstItem27.setImageResource(R.drawable.none);
                imgSecondItem27.setVisibility(View.GONE);
                imgSecondItem27.setImageResource(R.drawable.none);
                imgThirdItem27.setVisibility(View.GONE);
                imgThirdItem27.setImageResource(R.drawable.none);
                mImageView27.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView27.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem27.getDrawable();
            Drawable itemSecond = imgSecondItem27.getDrawable();
            Drawable itemLast = imgThirdItem27.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView27.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView27");
                } else {
                    mImageView27.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView27");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem27.setImageBitmap(bitmapFirstItems);
                    imgFirstItem27.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView27");
                } else {
                    imgFirstItem27.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem27.setImageBitmap(bitmapSecondItems);
                    imgSecondItem27.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView27");
                } else {
                    imgSecondItem27.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem27.setImageBitmap(bitmapThirdItems);
                    imgThirdItem27.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView27");
                } else {
                    imgThirdItem27.setImageResource(R.drawable.none);

                }
            }
        } else if (selectedImageViewId == R.id.imageView28) {
            if (query == "") {
                imgFirstItem28.setVisibility(View.GONE);
                imgFirstItem28.setImageResource(R.drawable.none);
                imgSecondItem28.setVisibility(View.GONE);
                imgSecondItem28.setImageResource(R.drawable.none);
                imgThirdItem28.setVisibility(View.GONE);
                imgThirdItem28.setImageResource(R.drawable.none);
                mImageView28.setImageResource(R.drawable.none);
            }
            Drawable champImg = mImageView28.getDrawable();
            Drawable imgDefault = getDrawable(R.drawable.none);
            Drawable itemFirst = imgFirstItem28.getDrawable();
            Drawable itemSecond = imgSecondItem28.getDrawable();
            Drawable itemLast = imgThirdItem28.getDrawable();

            if (champImg.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapChampionImage = GetChampionImageByName(query);
                if (bitmapChampionImage != null) {
                    mImageView28.setImageBitmap(bitmapChampionImage);
                    AddChampionDescription(query, "imageView28");
                } else {
                    mImageView28.setImageResource(R.drawable.none);
                    RemoveChampionDescription("imageView28");
                }

            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && itemFirst.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapFirstItems = GetItemByName(query);
                if (bitmapFirstItems != null) {
                    imgFirstItem28.setImageBitmap(bitmapFirstItems);
                    imgFirstItem28.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView28");
                } else {
                    imgFirstItem28.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && itemSecond.getConstantState().equals(imgDefault.getConstantState())) {

                Bitmap bitmapSecondItems = GetItemByName(query);
                if (bitmapSecondItems != null) {
                    imgSecondItem28.setImageBitmap(bitmapSecondItems);
                    imgSecondItem28.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView28");
                } else {
                    imgSecondItem28.setImageResource(R.drawable.none);

                }
            } else if (!champImg.getConstantState().equals(imgDefault.getConstantState())
                    && !itemFirst.getConstantState().equals(imgDefault.getConstantState())
                    && !itemSecond.getConstantState().equals(imgDefault.getConstantState())
                    && itemLast.getConstantState().equals(imgDefault.getConstantState())) {
                Bitmap bitmapThirdItems = GetItemByName(query);
                if (bitmapThirdItems != null) {
                    imgThirdItem28.setImageBitmap(bitmapThirdItems);
                    imgThirdItem28.setVisibility(View.VISIBLE);
                    AddItemEachChampionDescription(query, "imageView28");
                } else {
                    imgThirdItem28.setImageResource(R.drawable.none);

                }
            }
        }
        editTextView.setText("");
        editTextView.setVisibility(View.GONE);
    }

    public void submit(View view) {
        String nameOfTeam = teamName.getText().toString();
        myDB.addTeampComp(nameOfTeam);
        readDataTeampComp();
        int count = teamCompList.size();
        String teamCompID = teamCompList.get(count - 1).getTeamCompId();
        for (int i = 0; i < newTeamCompDesc.size(); i++) {
            newTeamCompDesc.get(i).setTeamCompID(teamCompID);
        }
        for (int i = 0; i < newTeamCompDesc.size(); i++) {
            myDB.addChampionDescription(
                    newTeamCompDesc.get(i).getTeamCompID(),
                    newTeamCompDesc.get(i).getChampionPlaceID(),
                    newTeamCompDesc.get(i).getChampionName(),
                    newTeamCompDesc.get(i).getFirstItemName(),
                    newTeamCompDesc.get(i).getSecondItemName(),
                    newTeamCompDesc.get(i).getThirdItemName());

        }
        Intent intent = new Intent(this, ShowTeamList.class);

        startActivity(intent);
    }
}