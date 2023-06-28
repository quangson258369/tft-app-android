package com.example.myapplication.Models;

public class TeamComp {

    private String TeamCompId;
   private String NameOfTeamComp;
public TeamComp() {}
    public TeamComp(String teamCompId, String nameOfTeamComp) {
        TeamCompId = teamCompId;
        NameOfTeamComp = nameOfTeamComp;
    }

    public String getTeamCompId() {
        return TeamCompId;
    }

    public void setTeamCompId(String teamCompId) {
        TeamCompId = teamCompId;
    }

    public String getNameOfTeamComp() {
        return NameOfTeamComp;
    }

    public void setNameOfTeamComp(String nameOfTeamComp) {
        NameOfTeamComp = nameOfTeamComp;
    }
}
