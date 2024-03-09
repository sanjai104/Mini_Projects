import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class User {
    private static JTextField guessField;
    private static JLabel resultLabel;
    private static int randomNumber;
    private static int attempts = 5;

    public static void main(String[] args) {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));

        JLabel promptLabel = new JLabel("Enter your guess (1-100):");
        contentPane.add(promptLabel);

        guessField = new JTextField();
        contentPane.add(guessField);

        resultLabel = new JLabel("");
        contentPane.add(resultLabel);

        guessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private static void checkGuess() {
        int guessNumber = Integer.parseInt(guessField.getText());
        if (guessNumber == randomNumber) {
            resultLabel.setText("Correct! You win!");
        } else if (guessNumber > randomNumber) {
            attempts--;
            resultLabel.setText("Sorry! Your guess is higher. Try again!! Attempts left: " + attempts);
        } else {
            attempts--;
            resultLabel.setText("Sorry! Your guess is lower. Try again!! Attempts left: " + attempts);
        }
        if (attempts == 0) {
            resultLabel.setText("Sorry! You've exhausted all your attempts. The number was " + randomNumber);
        }
        guessField.setText("");
    }
}
