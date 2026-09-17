package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The rules
        System.out.println("Welcome in Guess The Number!");
        System.out.println("The rules are simple : give me a number between 0 and 100, and i'll tell you if this" +
                "\n is the right number." +
                "\n If it is not, you try again." +
                "\n It it is, you won!");
        System.out.println("Your time to play! Give me a number between 0 and 100.");

        // Random generation of a number between 0 and 100
        Random rand = new Random();
        int solutionNumber = rand.nextInt(0, 100);

        // Variable which indicates if the number has been found
        boolean numberIsFind = false;

        // The game, continue until the number is found
        while(!numberIsFind) {

            // User input
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if(number >= 0 && number <= 100) {
                if(number == solutionNumber) {
                    numberIsFind = true;
                } else {
                    System.out.println("Wrong number! Try again.");
                }
            } else {
                System.out.println("Please enter a number between 0 and 100.");
            }
        }

        // Message of victory or loss
        if(numberIsFind) {
            System.out.println("The number is found!");
        }
    }
}