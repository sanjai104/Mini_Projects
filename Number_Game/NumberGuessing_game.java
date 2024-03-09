import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 3; // Number of rounds

        for(int i = 0; i < rounds; i++) {
            int randomNumber = random.nextInt(100) + 1;
            System.out.println("Round " + (i+1));
            int guessNumber; 
            int attempts = 5;
            int tryCount = 0;

            while(true) {
                tryCount++;
                if(tryCount > attempts) {
                    System.out.println("Sorry! You've exhausted all your attempts. The number was " + randomNumber);
                    break;
                }
                System.out.println("Enter your guess (1-100):");
                guessNumber = scanner.nextInt(); //  loop for multiple inputs

                if (guessNumber == randomNumber) {
                    System.out.println("Correct! You win!");
                    break;
                } else if (guessNumber > randomNumber) {
                    System.out.println("Sorry! Your guess is higher. Try again!!");
                } else {
                    System.out.println("Sorry! Your guess is lower. Try again!!");
                }
            }
            System.out.println("Congrats! Your Score for round " + (i+1) + " is " + (attempts - tryCount+1)); // Display the score.
        }
        scanner.close(); // close the scanner
    }
}
