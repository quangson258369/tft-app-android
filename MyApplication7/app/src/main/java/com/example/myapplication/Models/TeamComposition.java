package com.example.myapplication.Models;

import java.util.List;

public class TeamComposition {
    private int TeamCompId;
    private List<ChampionDescription> TeamCompDes;

    public int getTeamCompId() {
        return TeamCompId;
    }

    public void setTeamCompId(int teamCompId) {
        TeamCompId = teamCompId;
    }

    public List<ChampionDescription> getTeamCompDes() {
        return TeamCompDes;
    }

    public void setTeamCompDes(List<ChampionDescription> teamCompDes) {
        TeamCompDes = teamCompDes;
    }
}

class ChampionDescription {
    private String ChampionPlaceId;
    private String ChampionId;
    private List<String> ItemId;

    public String getChampionPlaceId() {
        return ChampionPlaceId;
    }

    public void setChampionPlaceId(String championPlaceId) {
        ChampionPlaceId = championPlaceId;
    }

    public String getChampionId() {
        return ChampionId;
    }

    public void setChampionId(String championId) {
        ChampionId = championId;
    }

    public List<String> getItemId() {
        return ItemId;
    }

    public void setItemId(List<String> itemId) {
        ItemId = itemId;
    }
}
