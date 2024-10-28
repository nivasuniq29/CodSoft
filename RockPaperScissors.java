import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        return choices[random.nextInt(3)];
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "tie";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock"))) {
            return "user";
        } else {
            return "computer";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.print("Choose rock, paper, or scissors (or type 'quit' to exit): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("quit")) {
                break;
            } else if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            String computerChoice = getComputerChoice();
            System.out.println("Computer chose: " + computerChoice);

            String winner = determineWinner(userChoice, computerChoice);
            if (winner.equals("user")) {
                System.out.println("You win this round!");
                userScore++;
            } else if (winner.equals("computer")) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Score - You: " + userScore + ", Computer: " + computerScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
