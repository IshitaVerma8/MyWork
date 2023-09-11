package com.example.milestone2game.entities;
import com.example.milestone2game.R;

import java.io.Serializable;

public class Tower implements Serializable {
    private String type;
    private int buyPrice;
    private int upgradePrice;
    private int attackStrength;
    private int attackRadius;
    private Tile location;
    private int towerIcon;
    private int level;

    public String getType() {
        return type;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getUpgradePrice() {
        return upgradePrice;
    }

    public Tile getLocation() {
        return location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setUpgradePrice(int upgradePrice) {
        this.upgradePrice = upgradePrice;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getAttackRadius() {
        return attackRadius;
    }

    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    public void setLocation(Tile location) {
        this.location = location;
    }

    public int getTowerIcon() {
        return towerIcon;
    }

    public void setTowerIcon(int towerIcon) {
        this.towerIcon = towerIcon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Tower(String type, String difficulty, Tile location) {
        this.type = type;
        this.buyPrice = calculateTowerPrice(type, difficulty);
        this.upgradePrice = (int) (buyPrice / 2);
        this.location = location;
        this.location = location;
        this.level = 1;

        int baseAttackStrength = (int) (buyPrice / 3);
        int baseAttackRadius = (int) (buyPrice / 4);

        // Gryffindor specializes in attackStrength, but has poor attack radius
        // Hufflepuff specializes in attackRadius, but has poor attack strength
        // Ravenclaw has medium attack radius, but slightly lower attack strength
        // Slytherin has medium attack strength, and a slightly lower attack radius

        if (type.equals("Gryffindor")) {
            this.towerIcon = R.drawable.tower_gryffindor;
            baseAttackStrength *= 3;
        } else if (type.equals("Hufflepuff")) {
            this.towerIcon = R.drawable.tower_hufflepuff;
            baseAttackRadius *= 3;
        } else if (type.equals("Ravenclaw")) {
            this.towerIcon = R.drawable.tower_ravenclaw;
            baseAttackRadius = (int) (baseAttackRadius * 1.75);
            baseAttackStrength = (int) (baseAttackStrength * 1.5);
        } else {
            this.towerIcon = R.drawable.tower_slytherin;
            baseAttackRadius = (int) (baseAttackRadius * 1.5);
            baseAttackStrength = (int) (baseAttackStrength * 1.75);
        }

        this.attackStrength = baseAttackStrength;
        this.attackRadius = baseAttackRadius;
    }

    public static int calculateTowerPrice(String type, String difficulty) {
        int basePrice;
        if (type.equals("Gryffindor")) {
            basePrice = 10;
        } else if (type.equals("Hufflepuff")) {
            basePrice = 8;
        } else if (type.equals("Ravenclaw")) {
            basePrice = 8;
        } else {
            basePrice = 6;
        }

        int buyPrice = basePrice;
        if (difficulty.equals("Medium")) {
            buyPrice = (int) (basePrice * 1.5);
        } else if (difficulty.equals("Hard")) {
            buyPrice = basePrice * 2;
        }

        return buyPrice;
    }

    public void upgradeTower() {
        level++;
        attackStrength += 5;
        attackRadius++;
    }
}
