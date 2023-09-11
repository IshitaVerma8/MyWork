package com.example.milestone2game.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private String name;
    private String difficulty;
    private int money;
    private String lastPurchased;

    private static List<Tower> towers;
    public static int moneySpent = 0;
    private static boolean winner = true;

    public Player() {
        towers = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        if (difficulty.equals("Easy")) {
            money = 70;
        } else if (difficulty.equals("Medium")) {
            money = 60;
        } else {
            money = 50;
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public String getName() {
        return this.name;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public String getLastPurchased() {
        return this.lastPurchased;
    }

    public void setLastPurchased(String lastPurchased) {
        this.lastPurchased = lastPurchased;
    }

    public static List<Tower> getTowers() {
        return towers;
    }

    public static void setTowers(List<Tower> towers) {
        Player.towers = towers;
    }
    public static int getMoneySpent() { return moneySpent; }

    public static void setMoneySpent(int moneySpent) { Player.moneySpent = moneySpent; }

    public static boolean isWinner() { return winner; }

    public static void setWinner(boolean winner) { Player.winner = winner; }
}
