package com.example.philip.pokedex;

/**
 * Created by Philip.
 */

public class Pokemon {

    private int id; //the number of the pokemon 1-151 in first generation.
    private String name, type, ability, baseHp, baseAtk, baseDef, baseSpAtk, baseSpDef, baseSpd, total;

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pokemon(int id, String name, String type, String ability,
                   String baseHp, String baseAtk, String baseDef,
                   String baseSpAtk, String baseSpDef,
                   String baseSpd, String total) {
        this.name = name;
        this.id = id;
        this.total = total;
        this.type = type;
        this.ability = ability;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpAtk = baseSpAtk;
        this.baseSpDef = baseSpDef;
        this.baseSpd = baseSpd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(String baseHp) {
        this.baseHp = baseHp;
    }

    public String getBaseAtk() {
        return baseAtk;
    }

    public void setBaseAtk(String baseAtk) {
        this.baseAtk = baseAtk;
    }

    public String getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(String baseDef) {
        this.baseDef = baseDef;
    }

    public String getBaseSpAtk() {
        return baseSpAtk;
    }

    public void setBaseSpAtk(String baseSpAtk) {
        this.baseSpAtk = baseSpAtk;
    }

    public String getBaseSpDef() {
        return baseSpDef;
    }

    public void setBaseSpDef(String baseSpDef) {
        this.baseSpDef = baseSpDef;
    }

    public String getBaseSpd() {
        return baseSpd;
    }

    public void setBaseSpd(String baseSpd) {
        this.baseSpd = baseSpd;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
