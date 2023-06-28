package com.example.myapplication.Models;

import com.google.gson.annotations.SerializedName;

public class SynergyLevel {
    @SerializedName("id")
    private String id;

    @SerializedName("units_required")
    private String unitsRequired;

    @SerializedName("style")
    private String style;

    @SerializedName("description")
    private String description;

    @SerializedName("maxUnits")
    private int maxUnits;

    @SerializedName("minUnits")
    private int minUnits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitsRequired() {
        return unitsRequired;
    }

    public void setUnitsRequired(String unitsRequired) {
        this.unitsRequired = unitsRequired;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxUnits() {
        return maxUnits;
    }

    public void setMaxUnits(int maxUnits) {
        this.maxUnits = maxUnits;
    }

    public int getMinUnits() {
        return minUnits;
    }

    public void setMinUnits(int minUnits) {
        this.minUnits = minUnits;
    }
}
