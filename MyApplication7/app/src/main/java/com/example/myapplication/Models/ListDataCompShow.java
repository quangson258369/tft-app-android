package com.example.myapplication.Models;

import java.io.Serializable;
import java.util.List;

public class ListDataCompShow implements Serializable {
private String TeamCompID;
    private String TeamCompName ;
    private List<ChampionCompUse>championCompUseList;
    private List<SynergyActive> synergyActivesList;

    public String getTeamCompName() {
        return TeamCompName;
    }

    public String getTeamCompID() {
        return TeamCompID;
    }

    public void setTeamCompID(String teamCompID) {
        TeamCompID = teamCompID;
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
