package com.example.milestone2game;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.milestone2game.entities.Enemy;
import com.example.milestone2game.entities.Monument;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestsM4 {

    private static final int TIMEOUT = 200;

    /**
     * Verifies that enemy count is updated appropriately after each Enemy is instantiated.
     */
    @Test
    public void testEnemyCountUpdatesCorrectly() {
        Enemy.setEnemyCount(0);

        Enemy enemy1 = new Enemy("Spider", "Easy", R.id.enemy1, R.id.enemy1Health);
        assertEquals(1, Enemy.getEnemyCount());

        Enemy enemy2 = new Enemy("Spider", "Easy", R.id.enemy1, R.id.enemy1Health);
        assertEquals(2, Enemy.getEnemyCount());

        Enemy enemy3 = new Enemy("Nagini", "Easy", R.id.enemy2, R.id.enemy2Health);
        assertEquals(3, Enemy.getEnemyCount());

        Enemy enemy4 = new Enemy("Dementor", "Easy", R.id.enemy3, R.id.enemy3Health);
        assertEquals(4, Enemy.getEnemyCount());
    }

    /**
     * Verifies the health values for all 3 types of enemies.
     */
    @Test
    public void testVerifyEnemyHealthByType() {
        Enemy dementor = new Enemy("Spider", "Easy", R.id.enemy1, R.id.enemy1Health);
        Enemy nagini = new Enemy("Nagini", "Easy", R.id.enemy2, R.id.enemy2Health);
        Enemy voldemort = new Enemy("Dementor", "Easy", R.id.enemy3, R.id.enemy3Health);

        assertEquals(40, dementor.getHealth());
        assertEquals(60, nagini.getHealth());
        assertEquals(100, voldemort.getHealth());
    }

    /**
     * Verifies that the health of a Dementor Enemy is the same across all difficulty levels.
     */
    @Test
    public void testVerifyDementorHealthSame() {
        Enemy dementorEasy = new Enemy("Dementor", "Easy", R.id.enemy1, R.id.enemy1Health);
        Enemy dementorMedium = new Enemy("Dementor", "Medium", R.id.enemy1, R.id.enemy1Health);
        Enemy dementorHard = new Enemy("Dementor", "Hard", R.id.enemy1, R.id.enemy1Health);

        int dementorEasyHealth = dementorEasy.getHealth();
        int dementorMediumHealth = dementorMedium.getHealth();
        int dementorHardHealth = dementorHard.getHealth();

        assertEquals(dementorEasyHealth, dementorMediumHealth);
        assertEquals(dementorEasyHealth, dementorHardHealth);
        assertEquals(dementorMediumHealth, dementorHardHealth);
    }

    /**
     * Verifies that the health of a Nagini Enemy is the same across all difficulty levels.
     */
    @Test
    public void testVerifyNaginiHealthSame() {
        Enemy naginiEasy = new Enemy("Nagini", "Easy", R.id.enemy2, R.id.enemy2Health);
        Enemy naginiMedium = new Enemy("Nagini", "Medium", R.id.enemy2, R.id.enemy2Health);
        Enemy naginiHard = new Enemy("Nagini", "Hard", R.id.enemy2, R.id.enemy2Health);

        int naginiEasyHealth = naginiEasy.getHealth();
        int naginiMediumHealth = naginiMedium.getHealth();
        int naginiHardHealth = naginiHard.getHealth();

        assertEquals(naginiEasyHealth, naginiMediumHealth);
        assertEquals(naginiEasyHealth, naginiHardHealth);
        assertEquals(naginiMediumHealth, naginiHardHealth);
    }

    /**
     * Verifies that the health of a Voldemort Enemy is the same across all difficulty levels.
     */
    @Test
    public void testVerifyVoldemortHealthSame() {
        Enemy voldemortEasy = new Enemy("Spider", "Easy", R.id.enemy3, R.id.enemy3Health);
        Enemy voldemortMedium = new Enemy("Spider", "Medium", R.id.enemy3, R.id.enemy3Health);
        Enemy voldemortHard = new Enemy("Spider", "Hard", R.id.enemy3, R.id.enemy3Health);

        int voldemortEasyHealth = voldemortEasy.getHealth();
        int voldemortMediumHealth = voldemortMedium.getHealth();
        int voldemortHardHealth = voldemortHard.getHealth();

        assertEquals(voldemortEasyHealth, voldemortMediumHealth);
        assertEquals(voldemortEasyHealth, voldemortHardHealth);
        assertEquals(voldemortMediumHealth, voldemortHardHealth);
    }

    /**
     * Verifies that the path duration of a Dementor Enemy varies across difficulty levels.
     *
     * The harder the difficulty, the lower the path duration should be so that the enemy moves
     * along the path faster.
     */
    @Test
    public void testCheckPathDurationVariesDemetor() {
        Enemy dementorEasy = new Enemy("Dementor", "Easy", R.id.enemy1, R.id.enemy1Health);
        Enemy dementorMedium = new Enemy("Dementor", "Medium", R.id.enemy1, R.id.enemy1Health);
        Enemy dementorHard = new Enemy("Dementor", "Hard", R.id.enemy1, R.id.enemy1Health);

        assertEquals(30000, dementorEasy.getPathDuration());
        assertEquals(22500, dementorMedium.getPathDuration());
        assertEquals(15000, dementorHard.getPathDuration());

        assertNotEquals(dementorEasy, dementorMedium);
        assertNotEquals(dementorEasy, dementorHard);
        assertNotEquals(dementorMedium, dementorHard);
    }

    /**
     * Verifies that the path duration of a Nagini Enemy varies across difficulty levels.
     *
     * The harder the difficulty, the lower the path duration should be so that the enemy moves
     * along the path faster.
     */
    @Test
    public void testCheckPathDurationVariesNagini() {
        Enemy naginiEasy = new Enemy("Nagini", "Easy", R.id.enemy2, R.id.enemy2Health);
        Enemy naginiMedium = new Enemy("Nagini", "Medium", R.id.enemy2, R.id.enemy2Health);
        Enemy naginiHard = new Enemy("Nagini", "Hard", R.id.enemy2, R.id.enemy2Health);

        assertEquals(30000, naginiEasy.getPathDuration());
        assertEquals(22500, naginiMedium.getPathDuration());
        assertEquals(15000, naginiHard.getPathDuration());

        assertNotEquals(naginiEasy, naginiMedium);
        assertNotEquals(naginiEasy, naginiHard);
        assertNotEquals(naginiMedium, naginiHard);
    }

    /**
     * Verifies that the path duration of a Voldemort Enemy varies across difficulty levels.
     *
     * The harder the difficulty, the lower the path duration should be so that the enemy moves
     * along the path faster.
     */
    @Test
    public void testCheckPathDurationVariesVoldemort() {
        Enemy voldemortEasy = new Enemy("Spider", "Easy", R.id.enemy3, R.id.enemy3Health);
        Enemy voldemortMedium = new Enemy("Spider", "Medium", R.id.enemy3, R.id.enemy3Health);
        Enemy voldemortHard = new Enemy("Spider", "Hard", R.id.enemy3, R.id.enemy3Health);

        assertEquals(30000, voldemortEasy.getPathDuration());
        assertEquals(22500, voldemortMedium.getPathDuration());
        assertEquals(15000, voldemortHard.getPathDuration());

        assertNotEquals(voldemortEasy, voldemortMedium);
        assertNotEquals(voldemortEasy, voldemortHard);
        assertNotEquals(voldemortMedium, voldemortHard);
    }

    /**
     * Verifies that game will go to game over screen the first time monument health is 0.
     * Verifies that enemy count is reset to 0 after game over.
     *
     * Also checks that after gameOver screen has been loaded once, it will not reload again.
     */
    @Test
    public void testCheckGameOverMonumentZeroHealth() {
        Monument monument = new Monument();
        monument.setHealth(0);
        assertEquals(true, Enemy.checkGoToGameOverScreen(monument));
        assertEquals(0, Enemy.getEnemyCount());
        Enemy.setGameOver(true);

        // we already went to the next screen, so should not load game over screen again
        assertEquals(false, Enemy.checkGoToGameOverScreen(monument));
    }

    /**
     * Verifies that game will not go to game over screen when monument health is positive.
     * Verifies that enemy count is not reset to 0 before game over.
     */
    @Test
    public void testCheckGameOverMonumentPositiveHealth() {
        Monument monument = new Monument();
        monument.setHealth(100);

        Enemy.setEnemyCount(0);
        Enemy voldemortHard = new Enemy("Dementor", "Hard", R.id.enemy3, R.id.enemy3Health);

        assertEquals(false, Enemy.checkGoToGameOverScreen(monument));
        assertEquals(1, Enemy.getEnemyCount());
    }
}