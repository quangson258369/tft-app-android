package com.example.myapplication.Models;

import android.graphics.Bitmap;

import java.io.Serializable;

public class SynergyActive implements Serializable {
    private String nameOfSynergyActive;
    private int activeCount;
    public int style;
    private Bitmap activeBitmap;

    public Bitmap getActiveBitmap() {
        return activeBitmap;
    }

    public void setActiveBitmap(Bitmap activeBitmap) {
        this.activeBitmap = activeBitmap;
    }

    public String getNameOfSynergyActive() {
        return nameOfSynergyActive;
    }

    public SynergyActive(){}
    public SynergyActive(String nameOfSynergyActive, int activeCount, int style,Bitmap activeBitmap) {
        this.nameOfSynergyActive = nameOfSynergyActive;
        this.activeCount = activeCount;
        this.style = style;
        this.activeBitmap = activeBitmap;
    }

    public int getStyle() {
        return style;
    }



    public void setStyle(int style) {
        this.style = style;
    }

    public void setNameOfSynergyActive(String nameOfSynergyActive) {
        this.nameOfSynergyActive = nameOfSynergyActive;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }


}
