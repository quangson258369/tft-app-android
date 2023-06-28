package com.example.myapplication.Models;

import android.graphics.Bitmap;

public class ChampionCompUse {

    public String nameChampion;
    public Bitmap ChampionBitmap;

    public ChampionCompUse(){}
    public ChampionCompUse(String nameChampion, Bitmap championBitmap) {
        this.nameChampion = nameChampion;
        ChampionBitmap = championBitmap;
    }

    public String getNameChampion() {
        return nameChampion;
    }

    public void setNameChampion(String nameChampion) {
        this.nameChampion = nameChampion;
    }

    public Bitmap getChampionBitmap() {
        return ChampionBitmap;
    }

    public void setChampionBitmap(Bitmap championBitmap) {
        ChampionBitmap = championBitmap;
    }
}
