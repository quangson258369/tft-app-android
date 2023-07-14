package com.example.myapplication.Models;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Augment implements Serializable {
    private String id;

    private String name;

    private String description;

    private String icon;

    private int level;

    private String tier;

    private String heroAugmentType;

    private Bitmap iconBitMap;

    public Augment(String name, String description, Bitmap iconBitMap) {
        this.name = name;
        this.description = description;
        this.iconBitMap = iconBitMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getHeroAugmentType() {
        return heroAugmentType;
    }

    public void setHeroAugmentType(String heroAugmentType) {
        this.heroAugmentType = heroAugmentType;
    }

    public Bitmap getIconBitmap() {
        return iconBitMap;
    }

    public void setIconBitmap(Bitmap championBitmap) {
        iconBitMap = championBitmap;
    }

}
