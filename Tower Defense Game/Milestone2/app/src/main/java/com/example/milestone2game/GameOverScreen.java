package com.example.milestone2game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.milestone2game.entities.Enemy;
import com.example.milestone2game.entities.Monument;
import com.example.milestone2game.entities.Player;

public class GameOverScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        openconfigurationscreen();
    }
    public void openconfigurationscreen() {
        if (Player.isWinner()) {
            setWinScreen();
        } else {
            setLoseScreen();
        }

        TextView enemiesKilledText = (TextView) findViewById(R.id.enemiesKilled);
        enemiesKilledText.setText("Enemies Killed: " + Enemy.getEnemyDeathCount());

        TextView damageTakenText = (TextView) findViewById(R.id.damageTaken);
        damageTakenText.setText("Damage Taken By Monument: " + Monument.getDamageTaken());

        TextView moneySpentText = (TextView) findViewById(R.id.moneySpent);
        moneySpentText.setText("Money Spent: " + Player.getMoneySpent());

        Button playAgainButton = (Button) findViewById(R.id.playAgain);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enemy.setEnemyDeathCount(0);
                Monument.setDamageTaken(0);
                Player.setMoneySpent(0);
                startActivity(new Intent(GameOverScreen.this, MainActivity.class));
            }
        });

        Button quitButton = (Button) findViewById(R.id.quitbutton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameOverScreen.this);
                builder.setTitle("Quit");
                builder.setMessage("Do you want to quit now?");
                builder.setPositiveButton("Yes. Quit now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                });
                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void setLoseScreen() {
        TextView gameResultText = (TextView) findViewById(R.id.gameResult);
        gameResultText.setText("YOU LOST");
        gameResultText.setTextColor(Color.RED);

        TextView gameMessageText = (TextView) findViewById(R.id.gameMessage);
        gameMessageText.setText("It's okay, you'll do better next time");
    }

    public void setWinScreen() {
        TextView gameResultText = (TextView) findViewById(R.id.gameResult);
        gameResultText.setText("YOU WON");
        gameResultText.setTextColor(Color.GREEN);

        TextView gameMessageText = (TextView) findViewById(R.id.gameMessage);
        gameMessageText.setText("Congrats!");

    }
}