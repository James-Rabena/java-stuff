import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class App {
    private static EJeepneyCard card;

    public static void main(String[] args) {
        JFrame frame = new JFrame("EJeepney Card System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        // Add a window listener for exit message
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you for using the EJeepney Card System!");
            }
        });

        JButton btnCreate = new JButton("Create New Card");
        JButton btnLoad = new JButton("Load Money");
        JButton btnTap = new JButton("Tap for Ride");
        JButton btnInfo = new JButton("View Card Info");

        btnCreate.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter cardholder name:");
            if (name != null && !name.trim().isEmpty()) {
                card = new EJeepneyCard(name.trim());
                JOptionPane.showMessageDialog(frame,
                        "New card created for " + name + "!\nCard Number: " + card.getCardNumber());
            } else {
                JOptionPane.showMessageDialog(frame, "Name cannot be empty.");
            }
        });

        btnLoad.addActionListener(e -> {
            if (card == null) {
                JOptionPane.showMessageDialog(frame, "Please create a card first.");
                return;
            }
            String input = JOptionPane.showInputDialog(frame, "Enter amount to load:");
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    card.loadMoney(amount);
                    JOptionPane.showMessageDialog(frame,
                        String.format("Loaded Php %.2f. New balance: Php %.2f.", amount, card.getBalance()));
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid amount to load.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount.");
            }
        });

        btnTap.addActionListener(e -> {
            if (card == null) {
                JOptionPane.showMessageDialog(frame, "Please create a card first.");
                return;
            }
            String input = JOptionPane.showInputDialog(frame, "Enter fare amount:");
            try {
                double fare = Double.parseDouble(input);
                if (fare > 0) {
                    if (card.tap(fare)) {
                        JOptionPane.showMessageDialog(frame,
                            String.format("Fare Php %.2f deducted. Remaining balance: Php %.2f.", fare, card.getBalance()));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid fare.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid fare.");
            }
        });

        btnInfo.addActionListener(e -> {
            if (card == null) {
                JOptionPane.showMessageDialog(frame, "Please create a card first.");
                return;
            }
            String info = "Card Number: " + card.getCardNumber() +
                    "\nCardholder: " + card.getName() +
                    "\nBalance: Php " + String.format("%.2f", card.getBalance());
            JOptionPane.showMessageDialog(frame, info);
        });

        frame.add(btnCreate);
        frame.add(btnLoad);
        frame.add(btnTap);
        frame.add(btnInfo);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}