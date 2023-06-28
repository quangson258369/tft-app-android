package com.example.myapplication.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Synergy {
    @SerializedName("synergyId")
    private String synergyId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("type")
    private String type;

    @SerializedName("tier")
    private String tier;

    @SerializedName("synergyLevel")
    private List<SynergyLevel> synergyLevels;

    public Synergy(){}
    public Synergy(String synergyId, String name, String description, String type, String tier, List<SynergyLevel> synergyLevels) {
        this.synergyId = synergyId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.tier = tier;
        this.synergyLevels = synergyLevels;
    }

    public String getSynergyId() {
        return synergyId;
    }

    public void setSynergyId(String synergyId) {
        this.synergyId = synergyId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public List<SynergyLevel> getSynergyLevels() {
        return synergyLevels;
    }

    public void setSynergyLevels(List<SynergyLevel> synergyLevels) {
        this.synergyLevels = synergyLevels;
    }
}

