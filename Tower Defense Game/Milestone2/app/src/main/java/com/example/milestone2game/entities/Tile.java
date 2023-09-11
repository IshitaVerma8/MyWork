package com.example.milestone2game.entities;
import android.widget.ImageButton;

public class Tile {
    private ImageButton tileButton;
    private Tower tower;
    private boolean clicked;

    public Tile(ImageButton btn) {
        this.tileButton = btn;
        this.tower = null;
        this.clicked = false;
    }

    public void setTileButton(ImageButton btn) {

        this.tileButton = btn;
    }

    public ImageButton getTileButton() {

        return tileButton;
    }

    public void setTower(Tower tower) {
        this.tower = tower; }

    public Tower getTower() {
        return tower; }

    public void setClicked(boolean clicked) {
        this.clicked = clicked; }

    public boolean getClicked() {
        return clicked;
    }
}
