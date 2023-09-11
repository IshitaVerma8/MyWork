package com.example.milestone2game;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.milestone2game.entities.Enemy;
import com.example.milestone2game.entities.BossEnemy;
import com.example.milestone2game.entities.Monument;
import com.example.milestone2game.entities.Player;
import com.example.milestone2game.entities.Shop;
import com.example.milestone2game.entities.Tile;

public class GameScreen extends AppCompatActivity {

    private Player player;
    private Shop shop;

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemap);
        opengamescreen();
        Intent intent = getIntent();

        player = (Player) intent.getSerializableExtra("currentPlayer");
        shop = new Shop(GameScreen.this, player);
        Monument monument = new Monument();

        String difficulty = player.getDifficulty();
        monument.setHealth(Monument.initializeHealth(difficulty));
        TextView moneyText = (TextView) findViewById(R.id.money);
        TextView healthText = (TextView) findViewById(R.id.health);
        moneyText.setText("Money: " + player.getMoney());
        healthText.setText("Health: " + monument.getHealth());

        ImageButton tile1Button = (ImageButton) findViewById(R.id.tile_1);
        Tile tile1 = new Tile(tile1Button);
        tile1Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile1);
            }
        });

        ImageButton tile2Button = (ImageButton) findViewById(R.id.tile_2);
        Tile tile2 = new Tile(tile2Button);
        tile2Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile2);
            }
        });

        ImageButton tile3Button = (ImageButton) findViewById(R.id.tile_3);
        Tile tile3 = new Tile(tile3Button);
        tile3Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile3);
            }
        });

        ImageButton tile4Button = (ImageButton) findViewById(R.id.tile_4);
        Tile tile4 = new Tile(tile4Button);
        tile4Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile4);
            }
        });

        ImageButton tile5Button = (ImageButton) findViewById(R.id.tile_5);
        Tile tile5 = new Tile(tile5Button);
        tile5Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile5);
            }
        });

        ImageButton tile6Button = (ImageButton) findViewById(R.id.tile_6);
        Tile tile6 = new Tile(tile6Button);
        tile6Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile6);
            }
        });
        ImageButton tile7Button = (ImageButton) findViewById(R.id.tile_7);
        Tile tile7 = new Tile(tile7Button);
        tile7Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile7);
            }
        });

        ImageButton tile8Button = (ImageButton) findViewById(R.id.tile_8);
        Tile tile8 = new Tile(tile8Button);
        tile8Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile8);
            }
        });
        ImageButton tile9Button = (ImageButton) findViewById(R.id.tile_9);
        Tile tile9 = new Tile(tile9Button);
        tile9Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile9);
            }
        });
        ImageButton tile10Button = (ImageButton) findViewById(R.id.tile_10);
        Tile tile10 = new Tile(tile10Button);
        tile10Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile10);
            }
        });
        ImageButton tile11Button = (ImageButton) findViewById(R.id.tile_11);
        Tile tile11 = new Tile(tile11Button);
        tile11Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile11);
            }
        });

        ImageButton tile12Button = (ImageButton) findViewById(R.id.tile_12);
        Tile tile12 = new Tile(tile12Button);
        tile12Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile12);
            }
        });

        ImageButton tile13Button = (ImageButton) findViewById(R.id.tile_13);
        Tile tile13 = new Tile(tile13Button);
        tile13Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile13);
            }
        });

        ImageButton tile14Button = (ImageButton) findViewById(R.id.tile_14);
        Tile tile14 = new Tile(tile14Button);
        tile14Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile14);
            }
        });

        ImageButton tile15Button = (ImageButton) findViewById(R.id.tile_15);
        Tile tile15 = new Tile(tile15Button);
        tile15Button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                onTileInteraction(tile15);
            }
        });

        Button startCombatButton = (Button) findViewById(R.id.start_combat);

        Path enemyPath = new Path();
        enemyPath.lineTo(420, 0);
        enemyPath.lineTo(420, 180);
        enemyPath.lineTo(710, 180);
        enemyPath.lineTo(710, 700);
        enemyPath.lineTo(120, 700);
        enemyPath.lineTo(120, 1230);
        enemyPath.lineTo(800, 1230);

        startCombatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enemy.setEnemyCount(0);
                Enemy enemy0 = new Enemy("Spider", difficulty, R.id.enemy0, R.id.enemy0Health);
                Enemy.setEnemyCount(0);
                Enemy enemy1 = new Enemy("Spider", difficulty, R.id.enemy1, R.id.enemy1Health);
                Enemy enemy2 = new Enemy("Spider", difficulty, R.id.enemy2, R.id.enemy2Health);
                Enemy enemy3 = new Enemy("Nagini", difficulty, R.id.enemy3, R.id.enemy3Health);
                Enemy enemy4 = new Enemy("Nagini", difficulty, R.id.enemy4, R.id.enemy4Health);
                Enemy enemy5 = new Enemy("Dementor", difficulty, R.id.enemy5, R.id.enemy5Health);
                Enemy enemy6 = new Enemy("Dementor", difficulty, R.id.enemy6, R.id.enemy6Health);
                Enemy bossEnemy = new BossEnemy("Voldemort", difficulty, R.id.bossEnemy, R.id.bossEnemyHealth, R.id.bossEnemyTitle);
                enemy0.setHealth(0);
                findViewById(enemy0.getImageSrc()).setVisibility(View.INVISIBLE);
                enemy0.startCombat(GameScreen.this, enemyPath, monument);
                enemy1.startCombat(GameScreen.this, enemyPath, monument);
                enemy2.startCombat(GameScreen.this, enemyPath, monument);
                enemy3.startCombat(GameScreen.this, enemyPath, monument);
                enemy4.startCombat(GameScreen.this, enemyPath, monument);
                enemy5.startCombat(GameScreen.this, enemyPath, monument);
                enemy6.startCombat(GameScreen.this, enemyPath, monument);
                bossEnemy.startCombat(GameScreen.this, enemyPath, monument);
            }
        });
    }

    public void opengamescreen() {
        Button quitButton = (Button) findViewById(R.id.quitbutton3);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameScreen.this);
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

    private void onTileInteraction(Tile tile) {
        TextView moneyText = (TextView) findViewById(R.id.money);

        if (!tile.getClicked()) {
            tile.setClicked(true);
            shop.displayBuyOptions(tile, moneyText);
            moneyText.setText("Money:" + player.getMoney());
        } else {
            shop.displayUpgradeOptions(tile, moneyText);
        }
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
}
