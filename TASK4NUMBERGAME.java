import java.util.*;

public class NUMBERGAME {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("=====================================");
        System.out.println(" 🎮 Welcome to the Guess The Number Game! ");
        System.out.println("=====================================");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess;

                // Input validation
                if (!sc.hasNextInt()) {
                    System.out.println(" Invalid input! Please enter a number.");
                    sc.next(); // clear invalid input
                    continue;
                }

                guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1) * 10; // higher score for fewer attempts
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println(" Too low! Try again.");
                } else {
                    System.out.println(" Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\n Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("\nCurrent Score: " + score);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n=====================================");
        System.out.println("  Game Over!");
        System.out.println("  Final Score: " + score);
        System.out.println("=====================================");
        System.out.println("Thanks for playing! 👋");

        sc.close();
    }
}
