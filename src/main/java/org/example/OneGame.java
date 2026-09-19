package org.example;

import java.util.Random;
import java.util.Scanner;

public class OneGame {
    private int score;

    public OneGame() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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
        setScore(scoreOneGame(nbrEssais));
        System.out.println("Your score is " + getScore() + " for this game.");
        System.out.println();
    }


    public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }


    public int userInput() {
        int number;
        do {
            System.out.println("Please enter a number between 0 and 100 : ");
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
        } while(number < 0 || number > 100);

        return number;
    }


    public int compareNumbers(int number, int solutionNumber) {
        if(number == solutionNumber) {
            return 0;
        }

        if(solutionNumber > number) {
            return -1;
        }

        return 1;
    }


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
