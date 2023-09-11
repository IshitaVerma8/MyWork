package com.example.milestone2game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.example.milestone2game.entities.Tower;

import org.junit.Test;

public class UnitTestsM5 {
    private static final int TIMEOUT = 200;

    /**
     * Verifies that the distance formula works properly.
     */
    @Test
    public void testDistanceCalculator() {
        int calculatedDistance;

        calculatedDistance = (int) GameScreen.distance(0, 0, 3, 4);
        assertEquals(5, calculatedDistance);

        calculatedDistance = (int) GameScreen.distance(1, 1, 6, 13);
        assertEquals(13, calculatedDistance);
    }

    /**
     * Checks that the attack radius level varies based on type of tower on Easy difficulty
     */
    @Test
    public void testVaryingAttackRadiusEasy() {
        Tower gryffindorTower = new Tower("Gryffindor", "Easy", null);
        assertEquals(2, gryffindorTower.getAttackRadius());

        Tower hufflepuffTower = new Tower("Hufflepuff", "Easy", null);
        assertEquals(6, hufflepuffTower.getAttackRadius());

        Tower ravenclawTower = new Tower("Ravenclaw", "Easy", null);
        assertEquals(3, ravenclawTower.getAttackRadius());

        Tower slytherinTower = new Tower("Slytherin", "Easy", null);
        assertEquals(1, slytherinTower.getAttackRadius());

        assertNotEquals(gryffindorTower.getAttackRadius(), hufflepuffTower.getAttackRadius());
        assertNotEquals(gryffindorTower.getAttackRadius(), ravenclawTower.getAttackRadius());
        assertNotEquals(gryffindorTower.getAttackRadius(), slytherinTower.getAttackRadius());
        assertNotEquals(hufflepuffTower.getAttackRadius(), slytherinTower.getAttackRadius());
        assertNotEquals(ravenclawTower.getAttackRadius(), slytherinTower.getAttackRadius());
    }

    /**
     * Checks that the attack strength value varies based on type of tower on Easy difficulty
     */
    @Test
    public void testVaryingAttackStrengthEasy() {
        Tower gryffindorTower = new Tower("Gryffindor", "Easy", null);
        assertEquals(9, gryffindorTower.getAttackStrength());

        Tower hufflepuffTower = new Tower("Hufflepuff", "Easy", null);
        assertEquals(2, hufflepuffTower.getAttackStrength());

        Tower ravenclawTower = new Tower("Ravenclaw", "Easy", null);
        assertEquals(3, ravenclawTower.getAttackStrength());

        Tower slytherinTower = new Tower("Slytherin", "Easy", null);
        assertEquals(3, slytherinTower.getAttackStrength());

        assertNotEquals(gryffindorTower.getAttackStrength(), hufflepuffTower.getAttackStrength());
        assertNotEquals(gryffindorTower.getAttackStrength(), ravenclawTower.getAttackStrength());
        assertNotEquals(gryffindorTower.getAttackStrength(), slytherinTower.getAttackStrength());
        assertNotEquals(hufflepuffTower.getAttackStrength(), slytherinTower.getAttackStrength());
    }

    /**
     * Checks that the attack radius level varies based on type of tower on Medium difficulty
     */
    @Test
    public void testVaryingAttackRadiusMedium() {
        Tower gryffindorTower = new Tower("Gryffindor", "Medium", null);
        assertEquals(3, gryffindorTower.getAttackRadius());

        Tower hufflepuffTower = new Tower("Hufflepuff", "Medium", null);
        assertEquals(9, hufflepuffTower.getAttackRadius());

        Tower ravenclawTower = new Tower("Ravenclaw", "Medium", null);
        assertEquals(5, ravenclawTower.getAttackRadius());

        Tower slytherinTower = new Tower("Slytherin", "Medium", null);
        assertEquals(3, slytherinTower.getAttackRadius());

        assertNotEquals(gryffindorTower.getAttackRadius(), hufflepuffTower.getAttackRadius());
        assertNotEquals(gryffindorTower.getAttackRadius(), ravenclawTower.getAttackRadius());
        assertNotEquals(hufflepuffTower.getAttackRadius(), slytherinTower.getAttackRadius());
        assertNotEquals(ravenclawTower.getAttackRadius(), slytherinTower.getAttackRadius());
    }

    /**
     * Checks that the attack strength value varies based on type of tower on Medium difficulty
     */
    @Test
    public void testVaryingAttackStrengthMedium() {
        Tower gryffindorTower = new Tower("Gryffindor", "Medium", null);
        assertEquals(15, gryffindorTower.getAttackStrength());

        Tower hufflepuffTower = new Tower("Hufflepuff", "Medium", null);
        assertEquals(4, hufflepuffTower.getAttackStrength());

        Tower ravenclawTower = new Tower("Ravenclaw", "Medium", null);
        assertEquals(6, ravenclawTower.getAttackStrength());

        Tower slytherinTower = new Tower("Slytherin", "Medium", null);
        assertEquals(5, slytherinTower.getAttackStrength());

        assertNotEquals(gryffindorTower.getAttackStrength(), hufflepuffTower.getAttackStrength());
        assertNotEquals(gryffindorTower.getAttackStrength(), ravenclawTower.getAttackStrength());
        assertNotEquals(gryffindorTower.getAttackStrength(), slytherinTower.getAttackStrength());
        assertNotEquals(ravenclawTower.getAttackStrength(), slytherinTower.getAttackStrength());
    }

    /**
     * Checks that the attack radius level varies based on type of tower on Hard difficulty
     */
    @Test
    public void testVaryingAttackRadiusHard() {
        Tower gryffindorTower = new Tower("Gryffindor", "Hard", null);
        assertEquals(5, gryffindorTower.getAttackRadius());

        Tower hufflepuffTower = new Tower("Hufflepuff", "Hard", null);
        assertEquals(12, hufflepuffTower.getAttackRadius());

        Tower ravenclawTower = new Tower("Ravenclaw", "Hard", null);
        assertEquals(7, ravenclawTower.getAttackRadius());

        Tower slytherinTower = new Tower("Slytherin", "Hard", null);
        assertEquals(4, slytherinTower.getAttackRadius());

        assertNotEquals(gryffindorTower.getAttackRadius(), hufflepuffTower.getAttackRadius());
        assertNotEquals(gryffindorTower.getAttackRadius(), ravenclawTower.getAttackRadius());
        assertNotEquals(gryffindorTower.getAttackRadius(), slytherinTower.getAttackRadius());
        assertNotEquals(hufflepuffTower.getAttackRadius(), slytherinTower.getAttackRadius());
        assertNotEquals(ravenclawTower.getAttackRadius(), slytherinTower.getAttackRadius());
    }

    /**
     * Checks that the attack strength value varies based on type of tower on Hard difficulty
     */
    @Test
    public void testVaryingAttackStrengthHard() {
        Tower gryffindorTower = new Tower("Gryffindor", "Hard", null);
        assertEquals(18, gryffindorTower.getAttackStrength());

        Tower hufflepuffTower = new Tower("Hufflepuff", "Hard", null);
        assertEquals(5, hufflepuffTower.getAttackStrength());

        Tower ravenclawTower = new Tower("Ravenclaw", "Hard", null);
        assertEquals(7, ravenclawTower.getAttackStrength());

        Tower slytherinTower = new Tower("Slytherin", "Hard", null);
        assertEquals(7, slytherinTower.getAttackStrength());

        assertNotEquals(gryffindorTower.getAttackStrength(), hufflepuffTower.getAttackStrength());
        assertNotEquals(gryffindorTower.getAttackStrength(), ravenclawTower.getAttackStrength());
        assertNotEquals(gryffindorTower.getAttackStrength(), slytherinTower.getAttackStrength());
    }

    /**
     * Checks that the attack radius level of the Gryffindor tower varies based on difficulty
     */
    @Test
    public void testGryffindorTowerVaryingProximity() {
        Tower easyGTower = new Tower("Gryffindor", "Easy", null);
        assertEquals(2, easyGTower.getAttackRadius());

        Tower mediumGTower = new Tower("Gryffindor", "Medium", null);
        assertEquals(3, mediumGTower.getAttackRadius());

        Tower hardGTower = new Tower("Gryffindor", "Hard", null);
        assertEquals(5, hardGTower.getAttackRadius());

        assertNotEquals(easyGTower.getAttackRadius(), mediumGTower.getAttackRadius());
        assertNotEquals(easyGTower.getAttackRadius(), hardGTower.getAttackRadius());
        assertNotEquals(mediumGTower.getAttackRadius(), hardGTower.getAttackRadius());
    }

    /**
     * Checks that the attack radius level of the Hufflepuff tower varies based on difficulty
     */
    @Test
    public void testHufflepuffTowerVaryingProximity() {
        Tower easyHTower = new Tower("Hufflepuff", "Easy", null);
        assertEquals(6, easyHTower.getAttackRadius());

        Tower mediumHTower = new Tower("Hufflepuff", "Medium", null);
        assertEquals(9, mediumHTower.getAttackRadius());

        Tower hardHTower = new Tower("Hufflepuff", "Hard", null);
        assertEquals(12, hardHTower.getAttackRadius());

        assertNotEquals(easyHTower.getAttackRadius(), mediumHTower.getAttackRadius());
        assertNotEquals(easyHTower.getAttackRadius(), hardHTower.getAttackRadius());
        assertNotEquals(mediumHTower.getAttackRadius(), hardHTower.getAttackRadius());
    }

    /**
     * Checks that the attack radius level of the Hufflepuff tower varies based on difficulty
     */
    @Test
    public void testRavenclawTowerVaryingProximity() {
        Tower easyRTower = new Tower("Ravenclaw", "Easy", null);
        assertEquals(3, easyRTower.getAttackRadius());

        Tower mediumRTower = new Tower("Ravenclaw", "Medium", null);
        assertEquals(5, mediumRTower.getAttackRadius());

        Tower hardRTower = new Tower("Ravenclaw", "Hard", null);
        assertEquals(7, hardRTower.getAttackRadius());

        assertNotEquals(easyRTower.getAttackRadius(), mediumRTower.getAttackRadius());
        assertNotEquals(easyRTower.getAttackRadius(), hardRTower.getAttackRadius());
        assertNotEquals(mediumRTower.getAttackRadius(), hardRTower.getAttackRadius());
    }

    /**
     * Checks that the attack radius level of the Hufflepuff tower varies based on difficulty
     */
    @Test
    public void testSlytherinTowerVaryingProximity() {
        Tower easySTower = new Tower("Slytherin", "Easy", null);
        assertEquals(1, easySTower.getAttackRadius());

        Tower mediumSTower = new Tower("Slytherin", "Medium", null);
        assertEquals(3, mediumSTower.getAttackRadius());

        Tower hardSTower = new Tower("Slytherin", "Hard", null);
        assertEquals(4, hardSTower.getAttackRadius());

        assertNotEquals(easySTower.getAttackRadius(), mediumSTower.getAttackRadius());
        assertNotEquals(easySTower.getAttackRadius(), hardSTower.getAttackRadius());
        assertNotEquals(mediumSTower.getAttackRadius(), hardSTower.getAttackRadius());
    }

}
