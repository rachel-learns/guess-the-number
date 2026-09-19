package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }


    public static int userInput() {
        int number;
        do {
            System.out.println("Please enter a number between 0 and 100 : ");
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
        } while(number < 0 || number > 100);

        return number;
    }


    public static int compareNumbers(int number, int solutionNumber) {
        if(number == solutionNumber) {
            return 0;
        }

        if(solutionNumber > number) {
            return -1;
        }

        return 1;
    }


    public static int scoreOneGame(int nbrEssais) {
        // Return the score of this game
        int score;
        if(nbrEssais == 5) {
            score = 10;
        } else {
            score = nbrEssais;
        }

        return score;
    }


    public static void main(String[] args) {
        boolean wantsToPlay = true;
        int gameMax = 10;
        int finalScore = 0;

        do {
            gameMax--;

            // The rules
            System.out.println("Welcome in Guess The Number!");
            System.out.println("The rules are simple : give me a number between 0 and 100, " +
                    "and i tell you if this is the right number.");
            System.out.println("If it is not, you try again.");
            System.out.println("It it is, you won!");
            System.out.println("Your time to play!");
            System.out.println();

            // Random generation of a number between 0 and 100
            int solutionNumber = generateRandomNumber(0, 100);
            //System.out.println(solutionNumber);

            // Variables initializations
            boolean numberIsFind = false;
            int nbrEssais = 5;
            int number;

            // The game continue until the number is found or until there is no attempts left
            while (!numberIsFind && nbrEssais > 0) {
                // The user enters a number
                number = userInput();
                nbrEssais--;

                // The program compares the user's test with the solution
                int hint = compareNumbers(number, solutionNumber);

                // We display a hint to help the user find the solution number
                if (hint == 0) {
                    numberIsFind = true;
                } else {
                    if (hint == -1) {
                        System.out.println("The solution number is bigger than the number.");
                    } else {
                        System.out.println("The solution number is smaller than the number.");
                    }

                    System.out.println("Try again. You have " + nbrEssais + " attempts left.");
                    System.out.println();
                }
            }

            // Message of victory or loss
            if (numberIsFind) {
                System.out.println("The number is found! You won! GG!");
            } else {
                System.out.println("The number is not found! You lose! It was " + solutionNumber + ".");
            }

            // We display the score of this game
            int score = scoreOneGame(nbrEssais);
            System.out.println("Your score is " + score + " for this game.");
            System.out.println();

            // Keep track of the final score
            finalScore = finalScore + score;

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