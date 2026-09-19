package org.example;

import org.junit.jupiter.api.Test;

public class MainTest {
    OneGame game = new OneGame();

    @Test
    public void generateRandomNumberTest() {
        game.generateRandomNumber(0,100);

    }
}
