package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean wantsToPlay = true;
        int gameMax = 10;
        int finalScore = 0;

        do {
            // The rules
            System.out.println("Welcome in Guess The Number!");
            System.out.println("The rules are simple : give me a number between 0 and 100, " +
                    "and i tell you if this is the right number.");
            System.out.println("If it is not, you try again.");
            System.out.println("It it is, you won!");
            System.out.println("Your time to play!");
            System.out.println();

            OneGame game = new OneGame();
            gameMax--;

            // Start of the game
            game.start();

            // Keep track of the final score
            finalScore = finalScore + game.getScore();

            // Ask the user if he wants to keep playing
            System.out.println("Do you want to continue playing? (y/n) There is " + gameMax + " games left.");
            String c;
            do {
                Scanner scanner = new Scanner(System.in);
                c = scanner.next();
            } while(!c.equals("y") && !c.equals("n"));
            System.out.println();

            // If not, the game stops
            if(c.equals("n")) { wantsToPlay = false; }

        } while(wantsToPlay && gameMax > 0);

        // Print the final score and the number of played games
        gameMax = 10 - gameMax;
        System.out.println("Your final score is " + finalScore + " in " + gameMax + " games.");
    }
}