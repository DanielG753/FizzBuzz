package Daniel;

import java.util.Scanner;

/*
 * FizzBuzzBot handles all the gameplay logic.
 */

public class FizzBuzzBot {
    private static final String fizz = "fizz";
    private static final String buzz = "buzz";
    private static final Scanner scanner = new Scanner(System.in);

    // All the logic needed to have the bot play with the user.
    public static void playWithUser(int start, int end) {
        System.out.printf("Great! We'll count from %d to %d. I'll start.\n", start, end);
        boolean botTurn = true;
        String correctAnswer = "";

        // Use botTurn to decide whether to ask the player for an answer.
        // Make sure to change the turn after each iteration.
        for (int i = start; i <= end; i++) {
            correctAnswer = getFizzBuzz(i);
            if (botTurn) {
                System.out.println(correctAnswer);
                botTurn = false;
            } else {
                String response = scanner.nextLine().toLowerCase();
                if (response.equals(correctAnswer)) {
                    botTurn = true;
                } else {
                    System.out.printf("I'm sorry but that's not the right answer. You should have said %s.\n", correctAnswer);
                    i = end;
                }
            }
        }
    }

    // All the logic needed for the bot to play with itself
    public static void playSolo(int start, int end) {
        System.out.printf("Great! I'll count from %d to %d.\n", start, end);
        for (int i = start; i <= end; i++) {
            System.out.println(getFizzBuzz(i));
        }
    }

    // Return the correct response for the current count of the game as a String that can be printed.
    private static String getFizzBuzz(int i) {
        String answer = i + "";

        if (i % 3 == 0) {
            if (i % 5 == 0) {
                answer = fizz + buzz;
            } else {
                answer = fizz;
            }
        } else if (i % 5 == 0) {
            answer = buzz;
        }

        return answer;
    }
}