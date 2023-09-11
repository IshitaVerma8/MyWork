package com.example.milestone2game.entities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.example.milestone2game.GameOverScreen;
import com.example.milestone2game.GameScreen;
import com.example.milestone2game.R;

import android.graphics.Path;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Enemy {

    private int id;
    private String type;
    private int health;
    private int pathDuration;
    private int imageSrc;
    private int healthTxtSrc;

    private static boolean gameOver = false;
    private static int enemyCount = 0;
    private static int enemyDeathCount = 0;

    public Enemy(String type, String difficulty, int imgSrc, int healthTxtSrc) {
        enemyCount++;
        this.id = enemyCount;
        this.type = type;
        int baseHealth;
        if (type.equals("Spider")) {
            baseHealth = 40;
        } else if (type.equals("Nagini")) {
            baseHealth = 60;
        } else if (type.equals("Dementor")) {
            baseHealth = 100;
        } else {
            baseHealth = 300;
        }
        this.health = baseHealth;
        this.imageSrc = imgSrc;
        this.healthTxtSrc = healthTxtSrc;
        int basePathDuration = 15000;
        if (difficulty.equals("Easy")) {
            this.pathDuration = basePathDuration * 2;
        } else if (difficulty.equals("Medium")) {
            this.pathDuration = (int) (basePathDuration * 1.5);
        } else {
            this.pathDuration = basePathDuration;
        }
        gameOver = false;
    }

    public void startCombat(GameScreen gameScreen, Path path, Monument monument) {
        int startDelay;
        if (type.equals("Spider") || type.equals("Nagini") || type.equals("Dementor")) {
            startDelay = (3000 * (id - 1)) + 1;
        } else {
            startDelay = getPathDuration() + 3000 * getEnemyCount();
            setPathDuration(30000);
        }
        ImageView enemyIcon = gameScreen.findViewById(imageSrc);
        TextView enemyHealthText = gameScreen.findViewById(healthTxtSrc);
        TextView moneyText = gameScreen.findViewById(R.id.money);
        TextView monHealthText = (TextView) gameScreen.findViewById(R.id.health);
        enemyHealthText.setText("Health: " + health);

        ObjectAnimator pathAnimatorEn =
                ObjectAnimator.ofFloat(enemyIcon, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        ObjectAnimator pathAnimatorTxt =
                ObjectAnimator.ofFloat(enemyHealthText,
                        View.TRANSLATION_X, View.TRANSLATION_Y, path);

        pathAnimatorEn.setStartDelay(startDelay);
        pathAnimatorTxt.setStartDelay(startDelay);
        pathAnimatorEn.setDuration(pathDuration);
        pathAnimatorTxt.setDuration(pathDuration);
        pathAnimatorEn.start();
        pathAnimatorTxt.start();

        pathAnimatorEn.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                enemyIcon.setVisibility(View.VISIBLE);
                enemyHealthText.setVisibility(View.VISIBLE);

                if (health <= 0) {
                    enemyIcon.setVisibility(View.INVISIBLE);
                    enemyHealthText.setVisibility(View.INVISIBLE);
                }

                Player player = gameScreen.getPlayer();

                Runnable helloRunnable = new Runnable() {
                    public void run() {
                        double[] enemyLocation = new double[2];
                        enemyLocation[0] = enemyIcon.getX();
                        enemyLocation[1] = enemyIcon.getY();
                        List<Tower> towers = Player.getTowers();
                        for (int i = 0; i < towers.size(); i++) {
                            Tower tower = towers.get(i);
                            int towerRadius = tower.getAttackRadius() * 125;
                            ImageButton towerIcon = tower.getLocation().getTileButton();
                            double distanceBetween =
                                    GameScreen.distance(towerIcon.getX(),
                                            towerIcon.getY(), enemyLocation[0], enemyLocation[1]);
                            if (distanceBetween <= towerRadius) {
                                System.out.println(distanceBetween
                                        + " is less than " + towerRadius);
                                if (health > 0) {
                                    health = health - tower.getAttackStrength();
                                }
                                enemyHealthText.setText("Health: " + health);
                                if (health <= 0 && enemyIcon.getVisibility() == View.VISIBLE) {
                                    enemyDeathCount++;
                                    enemyIcon.setVisibility(View.INVISIBLE);
                                    enemyHealthText.setVisibility(View.INVISIBLE);
                                    player.setMoney(player.getMoney() + 10);
                                    moneyText.setText("Money: " + player.getMoney());
                                    if (id == 6) {
                                        TextView prepareText = (TextView) gameScreen.findViewById(R.id.prepare);
                                        prepareText.setVisibility(View.VISIBLE);
                                    }
                                }
                            } else {
                                System.out.println(distanceBetween
                                        + " is not less than " + towerRadius);
                            }
                        }
                    }
                };
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                executor.scheduleAtFixedRate(helloRunnable, 2, 3, TimeUnit.SECONDS);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                int[] enemyLocation = new int[2];
                enemyIcon.getLocationOnScreen(enemyLocation);
                if (enemyLocation[0] == 800 && enemyLocation[1] == 1626 && health > 0) {
                    monument.setHealth(monument.getHealth() - health);
                    monHealthText.setText("Health: " + monument.getHealth());
                    int initMonumentHealth = Monument.initializeHealth(gameScreen.getPlayer().getDifficulty());
                    Monument.setDamageTaken(Monument.getDamageTaken() + health);
                    if (Monument.getDamageTaken() > initMonumentHealth) {
                        Monument.setDamageTaken(initMonumentHealth);
                    }
                    if (id == 6) {
                        TextView prepareText = (TextView) gameScreen.findViewById(R.id.prepare);
                        prepareText.setVisibility(View.VISIBLE);
                    }
                }
                enemyIcon.setVisibility(View.INVISIBLE);
                enemyHealthText.setVisibility(View.INVISIBLE);

                boolean goNext = checkGoToGameOverScreen(monument);
                if (goNext) {
                    gameScreen.startActivity(new Intent(gameScreen, GameOverScreen.class));
                }
            }

            @Override public void onAnimationRepeat(Animator animation) {}

            @Override public void onAnimationCancel(Animator animation) {}
        });
    }

    public static boolean checkGoToGameOverScreen(Monument monument) {
        if (monument.getHealth() <= 0 && !gameOver) {
            gameOver = true;
            enemyCount = 0;
            Player.setWinner(false);
            return true;
        }
        return false;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPathDuration() {
        return pathDuration;
    }

    public void setPathDuration(int pathDuration) {
        this.pathDuration = pathDuration;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Enemy.gameOver = gameOver;
    }

    public static int getEnemyCount() {
        return enemyCount;
    }

    public static void setEnemyCount(int enemyCount) {
        Enemy.enemyCount = enemyCount;
    }

    public int getHealthTxtSrc() { return healthTxtSrc; }

    public void setHealthTxtSrc(int healthTxtSrc) { this.healthTxtSrc = healthTxtSrc; }

    public static int getEnemyDeathCount() { return enemyDeathCount; }

    public static void setEnemyDeathCount(int enemyDeathCount) { Enemy.enemyDeathCount = enemyDeathCount; }
}
