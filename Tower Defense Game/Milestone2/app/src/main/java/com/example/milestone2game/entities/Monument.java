package com.example.milestone2game.entities;

import java.io.Serializable;

public class Monument implements Serializable {
    private int health;

    private static int damageTaken = 0;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public static int initializeHealth(String difficulty) {
        if (difficulty.equals("Easy")) {
            return 200;
        } else if (difficulty.equals("Medium")) {
            return 175;
        } else {
            return 150;
        }
    }

    public static int getDamageTaken() { return damageTaken; }

    public static void setDamageTaken(int damageTaken) { Monument.damageTaken = damageTaken; }
}
