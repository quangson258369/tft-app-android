package com.example.myapplication.Models;

import android.graphics.Bitmap;

import java.util.List;

public class Item {
    private String id;
    private String name;
    private String tier;
    private String description;
    private List<String>from;
    private boolean isBase;
    private String trait;
    private int specialstatus;
    private List<ItemEffect> effects;

    public List<String> getFrom() {
        return from;
    }

    public void setFrom(List<String> from) {
        this.from = from;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public int getSpecialstatus() {
        return specialstatus;
    }

    public void setSpecialstatus(int specialstatus) {
        this.specialstatus = specialstatus;
    }

    private boolean isUnique;

    private boolean isShadow;

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

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    public List<ItemEffect> getEffects() {
        return effects;
    }

    public void setEffects(List<ItemEffect> effects) {
        this.effects = effects;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public void setUnique(boolean unique) {
        isUnique = unique;
    }



    public boolean isShadow() {
        return isShadow;
    }

    public void setShadow(boolean shadow) {
        isShadow = shadow;
    }
}

