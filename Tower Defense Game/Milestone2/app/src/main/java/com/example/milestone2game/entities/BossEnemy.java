package com.example.milestone2game.entities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.view.View;
import android.widget.TextView;

import com.example.milestone2game.GameOverScreen;
import com.example.milestone2game.GameScreen;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BossEnemy extends Enemy {
    private int titleSrc;
    private int bossPathDuration;
    private int difficultyPathDuration;

    public BossEnemy(String type, String difficulty, int imgSrc, int healthTxtSrc, int bossTitleSrc) {
        super(type, difficulty, imgSrc, healthTxtSrc);
        bossPathDuration = 30000;
        difficultyPathDuration = getPathDuration();
        titleSrc = bossTitleSrc;
    }

    @Override
    public void startCombat(GameScreen gameScreen, Path path, Monument monument) {
        super.startCombat(gameScreen, path, monument);

        TextView bossTitleText = gameScreen.findViewById(titleSrc);
        ObjectAnimator pathAnimatorT =
                ObjectAnimator.ofFloat(bossTitleText, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        pathAnimatorT.setStartDelay(difficultyPathDuration + 3000 * getEnemyCount());
        pathAnimatorT.setDuration(bossPathDuration);
        pathAnimatorT.start();

        pathAnimatorT.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                bossTitleText.setVisibility(View.VISIBLE);

                Runnable helloRunnable = new Runnable() {
                    public void run() {
                        if (getHealth() <= 0 && bossTitleText.getVisibility() == View.VISIBLE) {
                            bossTitleText.setVisibility(View.INVISIBLE);
                            Player.setWinner(true);
                            setGameOver(true);
                            gameScreen.startActivity(new Intent(gameScreen, GameOverScreen.class));
                        }
                    }
                };
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                executor.scheduleAtFixedRate(helloRunnable, 2, 3, TimeUnit.SECONDS);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                bossTitleText.setVisibility(View.INVISIBLE);

                boolean goNext = checkGoToWinScreen(monument);
                if (goNext) {
                    gameScreen.startActivity(new Intent(gameScreen, GameOverScreen.class));
                }
            }

            @Override public void onAnimationRepeat(Animator animation) {}

            @Override public void onAnimationCancel(Animator animation) {}
        });
    }

    public static boolean checkGoToWinScreen(Monument monument) {
        if (monument.getHealth() > 0 && !isGameOver()) {
            setGameOver(true);
            Player.setWinner(true);
            return true;
        }
        return false;
    }

}
