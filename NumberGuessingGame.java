import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a command (rules or play): ");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("rules")) {
            displayRules();
            System.out.print("Do you want to play? (yes/no): ");
            String playResponse = scanner.nextLine();
            if (playResponse.equalsIgnoreCase("yes")) {
                playGame();
            } else {
                System.out.println("Goodbye!");
            }
        } else if (command.equalsIgnoreCase("play")) {
            playGame();
        } else {
            System.out.println("Invalid command. Please enter 'rules' or 'play'.");
        }
    }

    private static void displayRules() {
        System.out.println("Number Guessing Game Rules:");
        System.out.println("----------------------------");
        System.out.println("Objective:");
        System.out.println("The objective of the game is to guess a randomly generated number between 1 and 100 in as few attempts as possible.");
        System.out.println();
        System.out.println("Gameplay:");
        System.out.println("1. The game is played in rounds, with a maximum of 3 rounds.");
        System.out.println("2. At the start of each round, a random number between 1 and 100 is generated.");
        System.out.println("3. The player is prompted to guess the number, and their guess is compared to the generated number.");
        System.out.println("4. If the player's guess is too low, they are informed that their guess is too low. If their guess is too high, they are informed that their guess is too high.");
        System.out.println("5. The player has a limited number of attempts to guess the number correctly, based on the chosen difficulty level:");
        System.out.println("   * Easy: 10 attempts");
        System.out.println("   * Medium: 7 attempts");
        System.out.println("   * Hard: 5 attempts");
        System.out.println("6. If the player guesses the number correctly, they win the round and move on to the next round.");
        System.out.println("7. If the player runs out of attempts without guessing the number correctly, the round is over and the correct number is revealed.");
        System.out.println("8. The game continues for a maximum of 3 rounds.");
        System.out.println("9. The player's score is based on the number of rounds won and the total number of attempts taken.");
        System.out.println();
        System.out.println("Scoring:");
        System.out.println("* Each round won is worth 1 point.");
        System.out.println("* The total number of attempts taken is subtracted from the total score.");
        System.out.println("* The player's final score is the total number of points earned minus the total number of attempts taken.");
        System.out.println();
        System.out.println("Winning Conditions:");
        System.out.println("The game is won when the player completes all 3 rounds or achieves a score of 3 or higher.");
        System.out.println();
        System.out.println("Game Over:");
        System.out.println("The game is over when the player completes all 3 rounds or decides to quit playing.");
        System.out.println("----------------------------");
    }



    private static void  playGame() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Rules");
        System.out.print("Choose a difficulty level (easy, medium, hard): ");
        String difficulty = scanner.next().toLowerCase();
        int numAttempts;
        if (difficulty.equals("easy")) {
            numAttempts = 10;
        } else if (difficulty.equals("medium")) {
            numAttempts = 7;
        } else {
            numAttempts = 5;
        }

        int roundCount = 1;
        int totalAttempts = 0;

        while (roundCount <= 3) {
            Random random = new Random();
            int generatedNumber = random.nextInt(100) + 1;
            System.out.println("Round " + roundCount + ":");

            for (int attempt = 1; attempt <= numAttempts; attempt++) {
                System.out.print("Guess #" + attempt + ": ");
                int userGuess = scanner.nextInt();
                totalAttempts++;

                if (userGuess < generatedNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number correctly!");
                    break;
                }

                if (attempt == numAttempts) {
                    System.out.println("Sorry, you didn't guess the number. The correct number was " + generatedNumber + ".");
                }
            }

            roundCount++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Your total score is: " + (3 - (roundCount - 1)) + " out of 3, with a total of " + totalAttempts + " attempts.");
    }

    @Override
    public String toString() {
        return "NumberGuessingGame []";
    }
}
