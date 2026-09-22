package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneGameTest {
    OneGame game = new OneGame();

    @Test
    public void getScoreTest() {
        game.setScore(50);
        assertEquals(50, game.getScore());
    }

    @Test
    public void generateRandomNumberTest() {
        // Check if the generated number is between 0 and 100
        int number = game.generateRandomNumber(0, 100);
        assertTrue(number >= 0 && number <= 100);
    }

    @Test
    public void compareNumbersTest() {
        assertEquals(-1, game.compareNumbers(10, 20));
        assertEquals(1, game.compareNumbers(20, 10));
        assertEquals(0, game.compareNumbers(10, 10));
    }

    @Test
    public void scoreOneGameTest() {
        int score = game.scoreOneGame(4, true);
        assertEquals(10, score);

        int score1 = game.scoreOneGame(2, true);
        assertEquals(3, score1);

        int score2 = game.scoreOneGame(0, false);
        assertEquals(0, score2);

        int score3 = game.scoreOneGame(0, true);
        assertEquals(1, score3);
    }
}
