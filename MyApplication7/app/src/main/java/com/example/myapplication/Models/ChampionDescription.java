package com.example.myapplication.Models;

public class ChampionDescription {
    private String TeamCompID;
    private String ChampionName;
    private String ChampionPlaceID;
    private String FirstItemName;
    private String SecondItemName;
    private String ThirdItemName;
public ChampionDescription(){

}
    public ChampionDescription(String teamCompID, String championName, String championPlaceID, String firstItemName, String secondItemName, String thirdItemName) {
        TeamCompID = teamCompID;
        ChampionName = championName;
        ChampionPlaceID = championPlaceID;
        FirstItemName = firstItemName;
        SecondItemName = secondItemName;
        ThirdItemName = thirdItemName;
    }

    public String getTeamCompID() {
        return TeamCompID;
    }

    public void setTeamCompID(String teamCompID) {
        TeamCompID = teamCompID;
    }

    public String getChampionName() {
        return ChampionName;
    }

    public void setChampionName(String championName) {
        ChampionName = championName;
    }

    public String getChampionPlaceID() {
        return ChampionPlaceID;
    }

    public void setChampionPlaceID(String championPlaceID) {
        ChampionPlaceID = championPlaceID;
    }

    public String getFirstItemName() {
        return FirstItemName;
    }

    public void setFirstItemName(String firstItemName) {
        FirstItemName = firstItemName;
    }

    public String getSecondItemName() {
        return SecondItemName;
    }

    public void setSecondItemName(String secondItemName) {
        SecondItemName = secondItemName;
    }

    public String getThirdItemName() {
        return ThirdItemName;
    }

    public void setThirdItemName(String thirdItemName) {
        ThirdItemName = thirdItemName;
    }
}
