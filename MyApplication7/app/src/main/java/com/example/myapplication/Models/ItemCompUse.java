package com.example.myapplication.Models;

import android.graphics.Bitmap;

public class ItemCompUse {
    private String nameItem;
    private String descriptionItem;
    private Bitmap imageItem;

    public ItemCompUse(String nameItem, String descriptionItem, Bitmap imageItem) {
        this.nameItem = nameItem;
        this.descriptionItem = descriptionItem;
        this.imageItem = imageItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDescriptionItem() {
        return descriptionItem;
    }

    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    public Bitmap getImageItem() {
        return imageItem;
    }

    public void setImageItem(Bitmap imageItem) {
        this.imageItem = imageItem;
    }
}
