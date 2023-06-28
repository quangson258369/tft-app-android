package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Models.Champion;
import com.example.myapplication.Models.ChampionCompUse;
import com.example.myapplication.Models.ChampionDescription;
import com.example.myapplication.Models.Item;
import com.example.myapplication.Models.ListDataCompShow;
import com.example.myapplication.Models.Synergy;
import com.example.myapplication.Models.SynergyActive;
import com.example.myapplication.Models.SynergyLevel;
import com.example.myapplication.Models.TeamComp;
import com.example.myapplication.adapter.TeamComp_Adapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowTeamList extends AppCompatActivity {
    private RecyclerView rcvTeamComp;

    private TeamComp_Adapter teamComp_adapter;
    private List<Champion> ListChampions;
    private List<Item> ListItems;
    private List<Synergy> synergyList = new ArrayList<>();
    private List<SynergyActive> synergyActives;

    private List<ChampionCompUse> championCompUseList;
    private List<TeamComp> teamCompList = new ArrayList<>();
    private List<ChampionDescription> champDes = new ArrayList<>();
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_team_list);
        myDB = new DatabaseHelper(ShowTeamList.this);
        readJsonFile();
        readDataTeampComp();
        readDataChampionDes();
        rcvTeamComp = findViewById(R.id.rcvTeamComp);
        teamComp_adapter = new TeamComp_Adapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
         rcvTeamComp.setLayoutManager(linearLayoutManager);

        teamComp_adapter.setData(this, getListData());
        int count=getListData().size();
        rcvTeamComp.setAdapter(teamComp_adapter);


    }

    private void readJsonFile() {
        try {
            // Read the JSON file from the assets folder
            InputStream inputStream = getAssets().open("champions_en_US.json");
            InputStream inputStream2 = getAssets().open("items_en_US.json");
            InputStream inputStream3 = getAssets().open("synergies_en_US.json");
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
                Type listType3 = new TypeToken<List<Synergy>>() {
                }.getType();
                // Parse the JSON data into a list of Champion objects
                List<Champion> championList = gson.fromJson(reader, listType);

                ListChampions = championList;

                ListItems = gson.fromJson(reader2, listType2);
                List<Synergy> synergyData = gson.fromJson(reader3, listType3);
                List<Synergy> synergies = synergyData;
                for (Synergy s : synergies) {
                    // Access duelist properties
                    String synergyId = s.getSynergyId();
                    String name = s.getName();
                    String description = s.getDescription();
                    String type = s.getType();
                    String tier = s.getTier();

                    // Access synergyLevels list
                    List<SynergyLevel> synergyLevels = s.getSynergyLevels();

                    Synergy synergy = new Synergy(synergyId, name, description, type, tier, synergyLevels);
                    synergyList.add(synergy);
                }
                int total = synergyList.size();
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
                String teamCompId = cursor.getString(1);
                String ChampionPlaceID = cursor.getString(2);
                String ChampName = cursor.getString(3);
                String FirstItemName = cursor.getString(4);
                String SecondItemName = cursor.getString(5);
                String ThirdItemName = cursor.getString(6);
                ChampionDescription description =
                        new ChampionDescription(teamCompId, ChampName, ChampionPlaceID, FirstItemName, SecondItemName, ThirdItemName);
                champDes.add(description);
            }
        }
    }

    private List<ChampionDescription> championDescription(String id) {

        List<ChampionDescription> championDescriptionsSelect = new ArrayList<>();

        for (int i = 0; i < champDes.size(); i++) {
            if (champDes.get(i).getTeamCompID().equals(id)) {
                championDescriptionsSelect.add(champDes.get(i));
            }

        }

        return championDescriptionsSelect;
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

    public List<ChampionCompUse> championCompUseList(List<ChampionDescription> championDescriptions) {
        List<ChampionCompUse> championCompUseList = new ArrayList<>();
        for (int i = 0; i < championDescriptions.size(); i++) {

            try {
                Bitmap bitmap = GetChampionImageByName(championDescriptions.get(i).getChampionName());
                if (bitmap != null) {
                    ChampionCompUse championCompUse = new ChampionCompUse(championDescriptions.get(i).getChampionName(), bitmap);
                    championCompUseList.add(championCompUse);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return championCompUseList;

    }

    public List<SynergyActive> synergyActiveList(List<ChampionCompUse> championCompUseList) {
        List<SynergyActive> synergyActiveList = new ArrayList<>();
        List<String> SynergyCollectioms = new ArrayList<>();
        for (int i = 0; i < championCompUseList.size(); i++) {
            for (int j = 0; j < ListChampions.size(); j++) {
                if (championCompUseList.get(i).getNameChampion().equals(ListChampions.get(j).getName())) {
                    for (int h = 0; h < ListChampions.get(j).getClasses().size(); h++) {
                        SynergyCollectioms.add(ListChampions.get(j).getClasses().get(h));
                    }
                    for (int k = 0; k < ListChampions.get(j).getOrigins().size(); k++) {
                        SynergyCollectioms.add(ListChampions.get(j).getOrigins().get(k));
                    }
                }
            }
        }
        for (int i = 0; i < SynergyCollectioms.size(); i++) {
            SynergyActive newActive = new SynergyActive();
            if (synergyActiveList.size() == 0 || synergyActiveList == null) {
                int count = GetCount(SynergyCollectioms.get(i), SynergyCollectioms);
                if (setNewActive(count, SynergyCollectioms.get(i)) != null) {
                    newActive = setNewActive(count, SynergyCollectioms.get(i));
                    synergyActiveList.add(newActive);
                }
            } else {
                for (int j = 0; j < synergyActiveList.size(); j++) {
                    boolean exists=checkSynergyExist(SynergyCollectioms.get(i),synergyActiveList);
                    if (!exists) {
                        int count = GetCount(SynergyCollectioms.get(i), SynergyCollectioms);
                        if (setNewActive(count, SynergyCollectioms.get(i)) != null) {
                            newActive = setNewActive(count, SynergyCollectioms.get(i));
                            synergyActiveList.add(newActive);
                        }
                    }
                }

            }
        }

        Collections.sort(synergyActiveList, new SynergyActiveComparatorDescending());
        return synergyActiveList;
    }

    public boolean checkSynergyExist(String name, List<SynergyActive> synergyActiveList) {
        boolean exists= false;
        for(int i=0; i<synergyActiveList.size(); i++) {
            if(name.equals(synergyActiveList.get(i).getNameOfSynergyActive())){
                exists=true;
                return exists;
            }
        }
        return exists;
    }

    public SynergyActive setNewActive(int count, String name) {
        for (int j = 0; j < synergyList.size(); j++) {
            if (name.equals(synergyList.get(j).getSynergyId())) {
                int a = synergyList.get(j).getSynergyLevels().size();
                for (int h = 0; h < synergyList.get(j).getSynergyLevels().size(); h++) {
                    if (synergyList.get(j).getSynergyLevels().get(h).getMinUnits() == count
                            || synergyList.get(j).getSynergyLevels().get(h).getMaxUnits() == count
                    ) {
                        try {
                            int num = Integer.parseInt(synergyList.get(j).getSynergyLevels().get(h).getStyle());
                            String[] splitArray = name.split("_");
                            String imageName = "ic_" + splitArray[1];

                            int resourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());

                            if (resourceId != 0) {
                                Drawable drawable = getResources().getDrawable(resourceId);
                                SynergyActive newActive = new SynergyActive(name, count, num, drawableToBitmap(drawable));
                                return newActive;
                            } else {
                                throw new Exception("Invalid");
                            }


                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }
        return null;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // Create a Canvas object and associate it with the Bitmap
        Canvas canvas = new Canvas(bitmap);
        // Draw the Drawable onto the Canvas
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public int GetCount(String name, List<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                count++;
            }
        }
        return count;
    }

    class SynergyActiveComparatorDescending implements Comparator<SynergyActive> {

        @Override
        public int compare(SynergyActive o1, SynergyActive o2) {
            return Integer.compare(o2.style, o1.style);
        }
    }

    private List<ListDataCompShow> getListData() {
        List<ListDataCompShow> listDataCompShows = new ArrayList<>();
        for (int i = 0; i < teamCompList.size(); i++) {
            ListDataCompShow dataCompShow = new ListDataCompShow();
            dataCompShow.setTeamCompName(teamCompList.get(i).getNameOfTeamComp());
            List<ChampionDescription> championDescriptions = championDescription("" + teamCompList.get(i).getTeamCompId());
            List<ChampionCompUse> championCompUses = championCompUseList(championDescriptions);
            dataCompShow.setChampionCompUseList(championCompUses);
            List<SynergyActive> synergyActiveList = synergyActiveList(championCompUses);
            dataCompShow.setSynergyActivesList(synergyActiveList);
            listDataCompShows.add(dataCompShow);
        }
        return listDataCompShows;
    }
}