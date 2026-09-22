package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initializations of the variables
        boolean wantsToPlay = true;
        int gameMax = 10;
        int finalScore = 0;

        while(wantsToPlay && gameMax > 1) {
            OneGame game = new OneGame();
            gameMax--;

            // We start and play the game
            game.start();

            // Keep track of the final score
            finalScore = finalScore + game.getScore();

            // Ask the user if he wants to keep playing
            String message = String.format("Do you want to keep playing? (y/n) There is %d game%s left.",
                    gameMax, (gameMax > 1 ? "s" : ""));
            System.out.println(message);
            String c;
            do {
                Scanner scanner = new Scanner(System.in);
                c = scanner.next();
            } while(!c.equals("y") && !c.equals("n"));
            System.out.println();

            // If not, the game stops
            if(c.equals("n")) { wantsToPlay = false; }
        }

        // Start the last game
        if(wantsToPlay) {
            OneGame lastGame = new OneGame();
            lastGame.start();
            gameMax--;
            finalScore = finalScore + lastGame.getScore();
        }

        // Prints the final score and the number of played games.
        gameMax = 10 - gameMax;
        String message1 = String.format("Your final score is %d in %d game%s.",
                finalScore, gameMax, (gameMax > 1 ? "s" : ""));
        System.out.println(message1);
    }
}