package com.example.myapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Champion{
    private String id;
    private String name;
    private String tier;
    private int cost;
    private String origin;
    private String classunit;
    private String health;
    private String mana;
    private int startingmana;
    private String attackdamage;
    private String attackspeed;
    private String dps;
    private int attackrange;
    private int armor;
    private int magicresist;
    private List<String> items;
    private String abilityName;
    private String abilitydescription;
    private List<String> statusdescriptions;
    private int costreal;
    private List<String> origins;
    private List<String> classes;
    private int tierorder;
    private int health_value;
    private int dps_value;
    private int attack_damage_value;

    public Champion() {
    }

    // Getters and setters
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getClassunit() {
        return classunit;
    }

    public void setClassunit(String classunit) {
        this.classunit = classunit;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public int getStartingmana() {
        return startingmana;
    }

    public void setStartingmana(int startingmana) {
        this.startingmana = startingmana;
    }

    public String getAttackdamage() {
        return attackdamage;
    }

    public void setAttackdamage(String attackdamage) {
        this.attackdamage = attackdamage;
    }

    public String getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(String attackspeed) {
        this.attackspeed = attackspeed;
    }

    public String getDps() {
        return dps;
    }

    public void setDps(String dps) {
        this.dps = dps;
    }

    public int getAttackrange() {
        return attackrange;
    }

    public void setAttackrange(int attackrange) {
        this.attackrange = attackrange;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMagicresist() {
        return magicresist;
    }

    public void setMagicresist(int magicresist) {
        this.magicresist = magicresist;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilitydescription() {
        return abilitydescription;
    }

    public void setAbilitydescription(String abilitydescription) {
        this.abilitydescription = abilitydescription;
    }

    public List<String> getStatusdescriptions() {
        return statusdescriptions;
    }

    public void setStatusdescriptions(List<String> statusdescriptions) {
        this.statusdescriptions = statusdescriptions;
    }

    public int getCostreal() {
        return costreal;
    }

    public void setCostreal(int costreal) {
        this.costreal = costreal;
    }

    public List<String> getOrigins() {
        return origins;
    }

    public void setOrigins(List<String> origins) {
        this.origins = origins;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public int getTierorder() {
        return tierorder;
    }

    public void setTierorder(int tierorder) {
        this.tierorder = tierorder;
    }

    public int getHealth_value() {
        return health_value;
    }

    public void setHealth_value(int health_value) {
        this.health_value = health_value;
    }

    public int getDps_value() {
        return dps_value;
    }

    public void setDps_value(int dps_value) {
        this.dps_value = dps_value;
    }

    public int getAttack_damage_value() {
        return attack_damage_value;
    }

    public void setAttack_damage_value(int attack_damage_value) {
        this.attack_damage_value = attack_damage_value;
    }

}
