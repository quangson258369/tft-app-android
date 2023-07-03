package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private static final String TABLE1_NAME = "TeamComp";
    private static final String TABLE2_NAME = "ChampionDescription";

    // Table 1 columns
    private static final String TABLE1_COLUMN_TeamCompID = "TeamCompID";
    // ... other columns for table 1
    private static final String TABLE1_COLUMN_NameOfTeamComp = "NameOfTeamComp";


    // Table 2 columns
    private static final String TABLE2_COLUMN_ID = "id";
    private static final String TABLE2_COLUMN_TeamCompID = "TeamCompID";
    private static final String TABLE2_COLUMN_ChampionName = "ChampionName";
    private static final String TABLE2_COLUMN_ChampionPlaceID = "ChampionPlaceID";
    private static final String TABLE2_COLUMN_FirstItemName = "FirstItemName";
    private static final String TABLE2_COLUMN_SecondItemName = "SecondItemName";
    private static final String TABLE2_COLUMN_ThirdItemName = "ThirdItemName";

    private static final String CREATE_TABLE1 = "CREATE TABLE " + TABLE1_NAME +
            "(" + TABLE1_COLUMN_TeamCompID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE1_COLUMN_NameOfTeamComp + " TEXT" +

            // ... define other columns for table 1
            ")";

    private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE2_NAME +
            "(" + TABLE2_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            // ... define other columns for table 2
            TABLE2_COLUMN_TeamCompID + " TEXT," +
            TABLE2_COLUMN_ChampionPlaceID + " TEXT," +
            TABLE2_COLUMN_ChampionName + " TEXT," +
            TABLE2_COLUMN_FirstItemName + " TEXT," +
            TABLE2_COLUMN_SecondItemName + " TEXT," +
            TABLE2_COLUMN_ThirdItemName + " TEXT" +
            ")";
    private final Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE1);
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);


    }

    void addTeampComp(String NameOfTeamComp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TABLE1_COLUMN_NameOfTeamComp, NameOfTeamComp);
        long result = db.insert(TABLE1_NAME, null, cv);

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();

        }
    }

    void addChampionDescription(String TeamCompID, String ChampionPlaceID, String ChampionName, String FirstItem, String SecondItem, String ThirdItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TABLE2_COLUMN_TeamCompID, TeamCompID);
        cv.put(TABLE2_COLUMN_ChampionPlaceID, ChampionPlaceID);
        cv.put(TABLE2_COLUMN_ChampionName, ChampionName);
        cv.put(TABLE2_COLUMN_FirstItemName, FirstItem);
        cv.put(TABLE2_COLUMN_SecondItemName, SecondItem);
        cv.put(TABLE2_COLUMN_ThirdItemName, ThirdItem);
        long result = db.insert(TABLE2_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();

        }
    }

    public Cursor readTeamCompData() {
        String query = "SELECT * FROM " + TABLE1_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    public Cursor readChampionDesData() {
        String query = "SELECT * FROM " + TABLE2_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    void updateTeamCompData(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TABLE1_COLUMN_NameOfTeamComp, name);
        long result=db.update(TABLE1_NAME,cv,"TeamCompID=?",new String[]{id});
        if(result==-1){
            Toast.makeText(context,"Failed to update",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Successfully update",Toast.LENGTH_SHORT).show();

        }
    }
     void deleteChampionDescription(String TeamCompID){
         SQLiteDatabase db = this.getWritableDatabase();
         long result=db.delete(TABLE2_NAME,"TeamCompID=?",new String[]{TeamCompID});
         if(result==-1){
             Toast.makeText(context,"Failed to update",Toast.LENGTH_SHORT).show();
         }
         else{
             Toast.makeText(context,"Successfully update",Toast.LENGTH_SHORT).show();
         }
     }
    void deleteTeamComp(String TeamCompID){
        SQLiteDatabase db = this.getWritableDatabase();
        long result=db.delete(TABLE1_NAME,"TeamCompID=?",new String[]{TeamCompID});
        if(result==-1){
            Toast.makeText(context,"Failed to update",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Successfully update",Toast.LENGTH_SHORT).show();

        }
    }
}