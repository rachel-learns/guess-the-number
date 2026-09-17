package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The rules
        System.out.println("Welcome in Guess The Number!");
        System.out.println("The rules are simple : give me a number between 0 and 100, and i tell you if this is the right number." +
                "\n If it is not, you try again." +
                "\n It it is, you won!");
        System.out.println("Your time to play!");

        // Random generation of a number between 0 and 100
        Random rand = new Random();
        int solutionNumber = rand.nextInt(0, 100);

        // Variable which indicates if the number has been found
        boolean numberIsFind = false;
        int nbrEssais = 5;
        int number;

        // The game, continue until the number is found
        while(!numberIsFind && nbrEssais > 0) {

            // User input
            do {
                System.out.println("Please enter a number between 0 and 100 : ");
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextInt();
            } while(number < 0 || number > 100);

            if(number == solutionNumber) {
                numberIsFind = true;
            } else {
                nbrEssais--;

                if(number > solutionNumber) { System.out.println("The number is greater than the solution number"); }
                if(number < solutionNumber) { System.out.println("The number is less than the solution number"); }

                System.out.println("Try again.");
                System.out.println(nbrEssais + " attempts left.");
            }

        }

        // Message of victory or loss
        if(numberIsFind) {
            System.out.println("The number is found! You won! GG!");
        } else {
            System.out.println("The number is not found! You lose!");
        }
    }
}