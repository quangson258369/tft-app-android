package com.example.myapplication.Models;

import java.util.List;

public class ListDataCompShow {

    private String TeamCompName ;
    private List<ChampionCompUse>championCompUseList;
    private List<SynergyActive> synergyActivesList;

    public String getTeamCompName() {
        return TeamCompName;
    }

    public void setTeamCompName(String teamCompName) {
        TeamCompName = teamCompName;
    }

    public List<ChampionCompUse> getChampionCompUseList() {
        return championCompUseList;
    }

    public void setChampionCompUseList(List<ChampionCompUse> championCompUseList) {
        this.championCompUseList = championCompUseList;
    }

    public List<SynergyActive> getSynergyActivesList() {
        return synergyActivesList;
    }

    public void setSynergyActivesList(List<SynergyActive> synergyActivesList) {
        this.synergyActivesList = synergyActivesList;
    }
}
