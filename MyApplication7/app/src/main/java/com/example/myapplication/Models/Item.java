package com.example.myapplication.Models;

import java.util.List;
import java.util.Map;

public class Item {
    private String id;
    private String name;
    private String tier;
    private String description;
    private List<String> from;
    private boolean isBase;
    private String trait;
    private String specialStatus;
    private List<Effect> effects;
    private boolean isUnique;
    private Map<String, String> effectsNew;
    private boolean isShadow;

    // Constructor, getters, and setters

    public static class Effect {
        private String type;
        private int value;

        // Constructor, getters, and setters
    }

    public Item(String id, String name, String tier, String description, List<String> from, boolean isBase, String trait, String specialStatus, List<Effect> effects, boolean isUnique, Map<String, String> effectsNew, boolean isShadow) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.description = description;
        this.from = from;
        this.isBase = isBase;
        this.trait = trait;
        this.specialStatus = specialStatus;
        this.effects = effects;
        this.isUnique = isUnique;
        this.effectsNew = effectsNew;
        this.isShadow = isShadow;
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

    public List<String> getFrom() {
        return from;
    }

    public void setFrom(List<String> from) {
        this.from = from;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getSpecialStatus() {
        return specialStatus;
    }

    public void setSpecialStatus(String specialStatus) {
        this.specialStatus = specialStatus;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public void setUnique(boolean unique) {
        isUnique = unique;
    }

    public Map<String, String> getEffectsNew() {
        return effectsNew;
    }

    public void setEffectsNew(Map<String, String> effectsNew) {
        this.effectsNew = effectsNew;
    }

    public boolean isShadow() {
        return isShadow;
    }

    public void setShadow(boolean shadow) {
        isShadow = shadow;
    }
}

