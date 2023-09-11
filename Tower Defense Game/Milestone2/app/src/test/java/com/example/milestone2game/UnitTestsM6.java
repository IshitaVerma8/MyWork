package com.example.milestone2game;

import static org.junit.Assert.assertEquals;

import com.example.milestone2game.entities.Tower;

import org.junit.Test;

public class UnitTestsM6 {
    private static final int TIMEOUT = 200;

    /**
     * Verifies that the upgrade function works properly on Gryffindor Tower on Easy difficulty.
     */
    @Test
    public void testGryffindorTowerUpgradeEasy() {
        Tower easyGryffindorTower = new Tower("Gryffindor", "Easy", null);

        // verify initial statistics
        assertEquals(9, easyGryffindorTower.getAttackStrength());
        assertEquals(2, easyGryffindorTower.getAttackRadius());

        // upgrade tower
        easyGryffindorTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(14, easyGryffindorTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(3, easyGryffindorTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Gryffindor Tower on Medium difficulty.
     */
    @Test
    public void testGryffindorTowerUpgradeMedium() {
        Tower mediumGryffindorTower = new Tower("Gryffindor", "Medium", null);

        assertEquals(15, mediumGryffindorTower.getAttackStrength());
        assertEquals(3, mediumGryffindorTower.getAttackRadius());

        // upgrade tower
        mediumGryffindorTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(20, mediumGryffindorTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(4, mediumGryffindorTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Gryffindor Tower on Hard difficulty.
     */
    @Test
    public void testGryffindorTowerUpgradeHard() {
        Tower hardGryffindorTower = new Tower("Gryffindor", "Hard", null);

        // verify initial statistics
        assertEquals(18, hardGryffindorTower.getAttackStrength());
        assertEquals(5, hardGryffindorTower.getAttackRadius());

        // upgrade towers
        hardGryffindorTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(23, hardGryffindorTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(6, hardGryffindorTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Hufflepuff Tower on Easy difficulty.
     */
    @Test
    public void testHufflepuffTowerUpgradeEasy() {
        Tower easyHufflepuffTower = new Tower("Hufflepuff", "Easy", null);

        // verify initial statistics
        assertEquals(2, easyHufflepuffTower.getAttackStrength());
        assertEquals(6, easyHufflepuffTower.getAttackRadius());

        // upgrade tower
        easyHufflepuffTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(7, easyHufflepuffTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(7, easyHufflepuffTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Hufflepuff Tower on Medium difficulty.
     */
    @Test
    public void testHufflepuffTowerUpgradeMedium() {
        Tower mediumHufflepuffTower = new Tower("Hufflepuff", "Medium", null);

        assertEquals(4, mediumHufflepuffTower.getAttackStrength());
        assertEquals(9, mediumHufflepuffTower.getAttackRadius());

        // upgrade tower
        mediumHufflepuffTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(9, mediumHufflepuffTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(10, mediumHufflepuffTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Hufflepuff Tower on Hard difficulty.
     */
    @Test
    public void testHufflepuffTowerUpgradeHard() {
        Tower hardHufflepuffTower = new Tower("Hufflepuff", "Hard", null);

        // verify initial statistics
        assertEquals(5, hardHufflepuffTower.getAttackStrength());
        assertEquals(12, hardHufflepuffTower.getAttackRadius());

        // upgrade towers
        hardHufflepuffTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(10, hardHufflepuffTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(13, hardHufflepuffTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Ravenclaw Tower on Easy difficulty.
     */
    @Test
    public void testRavenclawTowerUpgradeEasy() {
        Tower easyRavenclawTower = new Tower("Ravenclaw", "Easy", null);

        // verify initial statistics
        assertEquals(3, easyRavenclawTower.getAttackStrength());
        assertEquals(3, easyRavenclawTower.getAttackRadius());

        // upgrade tower
        easyRavenclawTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(8, easyRavenclawTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(4, easyRavenclawTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Ravenclaw Tower on Medium difficulty.
     */
    @Test
    public void testRavenclawTowerUpgradeMedium() {
        Tower mediumRavenclawTower = new Tower("Ravenclaw", "Medium", null);

        assertEquals(6, mediumRavenclawTower.getAttackStrength());
        assertEquals(5, mediumRavenclawTower.getAttackRadius());

        // upgrade tower
        mediumRavenclawTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(11, mediumRavenclawTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(6, mediumRavenclawTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Ravenclaw Tower on Hard difficulty.
     */
    @Test
    public void testRavenclawTowerUpgradeHard() {
        Tower hardRavenclawTower = new Tower("Ravenclaw", "Hard", null);

        // verify initial statistics
        assertEquals(7, hardRavenclawTower.getAttackStrength());
        assertEquals(7, hardRavenclawTower.getAttackRadius());

        // upgrade towers
        hardRavenclawTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(12, hardRavenclawTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(8, hardRavenclawTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Slytherin Tower on Easy difficulty.
     */
    @Test
    public void testSlytherinTowerUpgradeEasy() {
        Tower easySlytherinTower = new Tower("Slytherin", "Easy", null);

        // verify initial statistics
        assertEquals(3, easySlytherinTower.getAttackStrength());
        assertEquals(1, easySlytherinTower.getAttackRadius());

        // upgrade tower
        easySlytherinTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(8, easySlytherinTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(2, easySlytherinTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Slytherin Tower on Medium difficulty.
     */
    @Test
    public void testSlytherinTowerUpgradeMedium() {
        Tower mediumSlytherinTower = new Tower("Slytherin", "Medium", null);

        assertEquals(5, mediumSlytherinTower.getAttackStrength());
        assertEquals(3, mediumSlytherinTower.getAttackRadius());

        // upgrade tower
        mediumSlytherinTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(10, mediumSlytherinTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(4, mediumSlytherinTower.getAttackRadius());
    }

    /**
     * Verifies that the upgrade function works properly on Slytherin Tower on Hard difficulty.
     */
    @Test
    public void testSlytherinTowerUpgradeHard() {
        Tower hardSlytherinTower = new Tower("Slytherin", "Hard", null);

        // verify initial statistics
        assertEquals(7, hardSlytherinTower.getAttackStrength());
        assertEquals(4, hardSlytherinTower.getAttackRadius());

        // upgrade towers
        hardSlytherinTower.upgradeTower();

        // verify attack strength is +5 compared to before
        assertEquals(12, hardSlytherinTower.getAttackStrength());
        // verify attack radius is +1 compared to before
        assertEquals(5, hardSlytherinTower.getAttackRadius());
    }
}
