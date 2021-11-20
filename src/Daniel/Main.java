package Daniel;

import java.util.Scanner;

/**
 * FizzBuzz is a classic math game for kids. Players take turns counting, while replacing any number divisible by 3 with
 * the word "fizz", any number divisible by 5 with the word "buzz" and any number divisible by both with the word
 * "fizzbuzz". This project will be able to play the game on its own, giving the solution between any interval. It will
 * also be able to play against the user up to the given number.
 *
 * @author Daniel Ginocchetti
 * @version 1.0
 * @since 2021-11-19
 */

public class Main {

    // The entry point of our program. Handles the main menu logic.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        String response = "";
        int start = 0;
        int end = 0;
        System.out.println("Hello, welcome to FizzBuzz!");
        do {
            // Check whether the user wants to play with the bot or not
            System.out.println("Would you like to play along? y/n");
            response = scanner.nextLine().toLowerCase();
            switch (response) {
                // Play with the user
                case "y":
                    System.out.println("Where should we start counting? Enter an integer:");
                    start = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("And where should we end? Enter an integer:");
                    end = scanner.nextInt();
                    scanner.nextLine();

                    FizzBuzzBot.playWithUser(start, end);

                    System.out.println("Would you like to play again? y/n");
                    response = scanner.nextLine().toLowerCase();
                    if (response.equals("n")){
                        quit = true;
                    }
                    break;

                // The bot plays with itself
                case "n":
                    System.out.println("Where should I start counting? Enter an integer:");
                    start = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("And where should I end? Enter an integer:");
                    end = scanner.nextInt();
                    scanner.nextLine();

                    FizzBuzzBot.playSolo(start, end);

                    System.out.println("Would you like to play again? y/n");
                    response = scanner.nextLine().toLowerCase();
                    if (response.equals("n")){
                        quit = true;
                    }
                    break;

                // Invalid input
                default:
                    System.out.println("I'm sorry I didn't understand your answer.");
                    break;
            }
        } while (!quit);
        System.out.println("Thank you for playing.");
    }
}