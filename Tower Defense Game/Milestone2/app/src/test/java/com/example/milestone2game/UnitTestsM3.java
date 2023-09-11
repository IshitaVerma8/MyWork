package com.example.milestone2game;
import org.junit.Test;

import static org.junit.Assert.*;


import com.example.milestone2game.entities.Enemy;
import com.example.milestone2game.entities.Monument;
import com.example.milestone2game.entities.Player;
import com.example.milestone2game.entities.Tower;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestsM3 {

    private static final int TIMEOUT = 200;

    /**
     * Checks to see if player starting money and monument health are set
     * appropriate for a game with Easy difficulty.
     */
    @Test
    public void testInitializeEasyGame() {
        Player player = new Player();
        player.setDifficulty("Easy");
        assertEquals(70, player.getMoney());

        Monument monument = new Monument();
        monument.setHealth(Monument.initializeHealth("Easy"));
        assertEquals(200, monument.getHealth());
    }

    /**
     * Checks to see if player starting money and monument health are set
     * appropriate for a game with Medium difficulty.
     */
    @Test
    public void testInitializeMediumGame() {
        Player player = new Player();
        player.setDifficulty("Medium");
        assertEquals(60, player.getMoney());

        Monument monument = new Monument();
        monument.setHealth(Monument.initializeHealth("Medium"));
        assertEquals(175, monument.getHealth());
    }

    /**
     * Checks to see if player starting money and monument health are set
     * appropriate for a game with Hard difficulty.
     */
    @Test
    public void testInitializeHardGame() {
        Player player = new Player();
        player.setDifficulty("Hard");
        assertEquals(player.getMoney(), 50);

        Monument monument = new Monument();
        monument.setHealth(Monument.initializeHealth("Hard"));
        assertEquals(150, monument.getHealth());
    }

    /**
     * Tests to see if the tower price for the gryffindor tower differs
     * across difficulties.
     */
    @Test
    public void testGryffindorBuyPriceVaries() {
        assertEquals(Tower.calculateTowerPrice("Gryffindor", "Easy"), 10);
        assertEquals(Tower.calculateTowerPrice("Gryffindor", "Medium"), 15);
        assertEquals(Tower.calculateTowerPrice("Gryffindor", "Hard"), 20);
    }

    /**
     * Tests to see if the tower price for the gryffindor tower differs
     * across difficulties.
     */
    @Test
    public void testHufflepuffBuyPriceVaries() {
        assertEquals(Tower.calculateTowerPrice("Hufflepuff", "Easy"), 8);
        assertEquals(Tower.calculateTowerPrice("Hufflepuff", "Medium"), 12);
        assertEquals(Tower.calculateTowerPrice("Hufflepuff", "Hard"), 16);
    }

    /**
     * Tests to see if the tower price for the gryffindor tower differs
     * across difficulties.
     */
    @Test
    public void testRavenclawBuyPriceVaries() {
        assertEquals(Tower.calculateTowerPrice("Ravenclaw", "Easy"), 8);
        assertEquals(Tower.calculateTowerPrice("Ravenclaw", "Medium"), 12);
        assertEquals(Tower.calculateTowerPrice("Ravenclaw", "Hard"), 16);
    }

    /**
     * Tests to see if the tower price for the gryffindor tower differs
     * across difficulties.
     */
    @Test
    public void testSlytherinBuyPriceVaries() {
        assertEquals(Tower.calculateTowerPrice("Slytherin", "Easy"), 6);
        assertEquals(Tower.calculateTowerPrice("Slytherin", "Medium"), 9);
        assertEquals(Tower.calculateTowerPrice("Slytherin", "Hard"), 12);
    }

    /**
     * Tests to see if the tower price for different towers costs
     * a different price on Easy.
     */
    @Test
    public void testDiffTowerPriceBetweenHousesEasy() {
        int gryffindorEasyPrice = Tower.calculateTowerPrice("Gryffindor", "Easy");
        int hufflepuffEasyPrice = Tower.calculateTowerPrice("Hufflepuff", "Easy");
        int ravenclawEasyPrice = Tower.calculateTowerPrice("Ravenclaw", "Easy");
        int slytherinEasyPrice = Tower.calculateTowerPrice("Slytherin", "Easy");
        assertEquals(gryffindorEasyPrice,  10);
        assertEquals(hufflepuffEasyPrice,  8);
        assertEquals(ravenclawEasyPrice,  8);
        assertEquals(slytherinEasyPrice,  6);

        assertEquals(gryffindorEasyPrice == hufflepuffEasyPrice, false);
        assertEquals(gryffindorEasyPrice == ravenclawEasyPrice, false);
        assertEquals(gryffindorEasyPrice == slytherinEasyPrice, false);
    }

    /**
     * Tests to see if the tower price for different towers costs
     * a different price on Medium.
     */
    @Test
    public void testDiffTowerPriceBetweenHousesMedium() {
        int gryffindorEasyPrice = Tower.calculateTowerPrice("Gryffindor", "Medium");
        int hufflepuffEasyPrice = Tower.calculateTowerPrice("Hufflepuff", "Medium");
        int ravenclawEasyPrice = Tower.calculateTowerPrice("Ravenclaw", "Medium");
        int slytherinEasyPrice = Tower.calculateTowerPrice("Slytherin", "Medium");
        assertEquals(gryffindorEasyPrice, 15);
        assertEquals(hufflepuffEasyPrice, 12);
        assertEquals(ravenclawEasyPrice, 12);
        assertEquals(slytherinEasyPrice, 9);

        assertEquals(gryffindorEasyPrice == hufflepuffEasyPrice, false);
        assertEquals(gryffindorEasyPrice == ravenclawEasyPrice, false);
        assertEquals(gryffindorEasyPrice == slytherinEasyPrice, false);
    }

    /**
     * Tests to see if the tower price for different towers costs
     * a different price on Hard.
     */
    @Test
    public void testDiffTowerPriceBetweenHousesHard() {
        int gryffindorEasyPrice = Tower.calculateTowerPrice("Gryffindor", "Hard");
        int hufflepuffEasyPrice = Tower.calculateTowerPrice("Hufflepuff", "Hard");
        int ravenclawEasyPrice = Tower.calculateTowerPrice("Ravenclaw", "Hard");
        int slytherinEasyPrice = Tower.calculateTowerPrice("Slytherin", "Hard");
        assertEquals(gryffindorEasyPrice, 20);
        assertEquals(hufflepuffEasyPrice, 16);
        assertEquals(ravenclawEasyPrice, 16);
        assertEquals(slytherinEasyPrice, 12);

        assertEquals(gryffindorEasyPrice == hufflepuffEasyPrice, false);
        assertEquals(gryffindorEasyPrice == ravenclawEasyPrice, false);
        assertEquals(gryffindorEasyPrice == slytherinEasyPrice, false);
    }


    // M4 TEST CASES

    /**
     * Verifies that the initial health of each enemy is correct.
     */
    @Test
    public void testVerifyEnemyHealthByType() {
        Enemy spider = new Enemy("Spider", "Easy", R.id.enemy1, R.id.enemy1Health);
        Enemy nagini = new Enemy("Nagini", "Easy", R.id.enemy2, R.id.enemy2Health);
        Enemy dementor = new Enemy("Dementor", "Easy", R.id.enemy3, R.id.enemy3Health);

        assertEquals(40, spider.getHealth());
        assertEquals(60, nagini.getHealth());
        assertEquals(100, dementor.getHealth());
    }

    /**
     *
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

    @Test
    public void testCheckPathDurationVariesVoldemort() {
        Enemy voldemortEasy = new Enemy("Voldemort", "Easy", R.id.enemy3, R.id.enemy3Health);
        Enemy voldemortMedium = new Enemy("Voldemort", "Medium", R.id.enemy3, R.id.enemy3Health);
        Enemy voldemortHard = new Enemy("Voldemort", "Hard", R.id.enemy3, R.id.enemy3Health);

        assertEquals(30000, voldemortEasy.getPathDuration());
        assertEquals(22500, voldemortMedium.getPathDuration());
        assertEquals(15000, voldemortHard.getPathDuration());

        assertNotEquals(voldemortEasy, voldemortMedium);
        assertNotEquals(voldemortEasy, voldemortHard);
        assertNotEquals(voldemortMedium, voldemortHard);
    }

    @Test
    public void testEnemyCountUpdatesCorrectly() {
        Enemy.setEnemyCount(0);

        Enemy enemy1 = new Enemy("Dementor", "Easy", R.id.enemy1, R.id.enemy1Health);
        Enemy enemy2 = new Enemy("Dementor", "Easy", R.id.enemy1, R.id.enemy1Health);
        Enemy enemy3 = new Enemy("Nagini", "Easy", R.id.enemy2, R.id.enemy2Health);
        Enemy enemy4 = new Enemy("Voldemort", "Easy", R.id.enemy3, R.id.enemy3Health);

        assertEquals(4, Enemy.getEnemyCount());
    }




}