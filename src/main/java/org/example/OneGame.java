package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * A class to create a game when needed.
 */
public class OneGame {
    private int score;

    /**
     * The class constructor.
     */
    public OneGame() {
        score = 0;
    }


    /**
     * To get the value of the score property.
     *
     * @return The value of the score property.
     */
    public int getScore() {
        return score;
    }


    /**
     * To change the score property.
     *
     * @param score The new score to replace the score property with.
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * Allow the user to start and play the game.
     */
    public void start() {
        // Random generation of a number between 0 and 100
        int solutionNumber = generateRandomNumber(0, 100);
        System.out.println(solutionNumber);

        // Initializations of the variables
        boolean numberIsFind = false;
        int nbrEssais = 5;
        int number;

        // The game continues until the number is found or until there is no attempts left
        while (!numberIsFind && nbrEssais > 0) {
            // The user enters a number
            number = userInput();
            nbrEssais--;

            // The program compares the user's test with the solution
            int hint = compareNumbers(number, solutionNumber);

            // We display an indication to help the user find the solution number
            if (hint == 0) {
                numberIsFind = true;
            } else {
                if (hint == -1) {
                    System.out.println("Your number is smaller than the solution.");
                } else {
                    System.out.println("Your number is bigger than the solution.");
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
        setScore(scoreOneGame(nbrEssais));
        System.out.println("Your score is " + getScore() + " for this game.");
        System.out.println();
    }


    /**
     * Generate a random number between a minimum bound and a maximum bound.
     *
     * @param min The minimum bound.
     * @param max The maximum bound.
     * @return The generated number.
     */
    public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }


    /**
     * Allow the user to enter a number.
     *
     * @return The number entered by the user.
     */
    public int userInput() {
        int number;
        do {
            System.out.println("Please enter a number between 0 and 100 : ");
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
        } while(number < 0 || number > 100);

        return number;
    }


    /**
     * Compare the numbers passed as parameters.
     *
     * @param number The number to compare.
     * @param solutionNumber The number to compare to.
     * @return A number indicating if number is equal, smaller or bigger than solutionNumber.
     */
    public int compareNumbers(int number, int solutionNumber) {
        if(number == solutionNumber) {
            return 0;
        }

        if(solutionNumber > number) {
            return -1;
        }

        return 1;
    }


    /**
     * Return the score of a game based on the number of left attempts.
     *
     * @param nbrEssais The number of left attempts.
     * @return The score of a game.
     */
    public int scoreOneGame(int nbrEssais) {
        int score;
        if(nbrEssais == 4) {
            score = 10;
        } else {
            score = nbrEssais;
        }

        return score;
    }
}
