import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserAccount {
    String name;
    int pin = 1234;
    int balance = 10000;
    int password;

    // Constructor
    UserAccount(int password, String name) {
        this.password = password;
        this.name = name;
    }

    void Deposit(int amount){
        balance = balance + amount;
        JOptionPane.showMessageDialog(null, "Successfully Credited. Your new balance is: " + balance);
    }
    void Withdraw(int amount){
        if(amount > balance)
        {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
        }
        else{
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Successfully Debited. Your new balance is: " + balance);
        }
    }
    void CheckBalance(){
        JOptionPane.showMessageDialog(null, "Your current balance: " + balance);
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM Machine");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserAccount atm = new UserAccount(Integer.parseInt(passwordText.getText()), userText.getText());
                if(atm.password == atm.pin) {
                    String[] options = {"Deposit", "Withdraw", "Check Balance", "Exit"};
                    while(true) {
                        int service = JOptionPane.showOptionDialog(null, "Select a service:", "ATM Machine", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        switch(service) {
                            case 0:
                                String depositAmount = JOptionPane.showInputDialog("Enter amount to deposit:");
                                atm.Deposit(Integer.parseInt(depositAmount));
                                break;
                            case 1:
                                String withdrawAmount = JOptionPane.showInputDialog("Enter amount to withdraw:");
                                atm.Withdraw(Integer.parseInt(withdrawAmount));
                                break;
                            case 2:
                                atm.CheckBalance();
                                break;
                            case 3:
                                System.exit(0);
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pin was incorrect. Try again!!");
                }
            }
        });
    }
}
