import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JFrame {

    JTextField input;
    JTextArea output;
    JButton button;

    public main() {
        setTitle("Score Analyzer");
        setSize(420, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter scores (space-separated):");
        input = new JTextField();
        button = new JButton("Check Scores");
        output = new JTextArea();
        output.setEditable(false);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 1));
        top.add(label);
        top.add(input);
        top.add(button);

        add(top, BorderLayout.NORTH);
        add(output, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doAnalysis();
            }
        });

        setVisible(true);
    }

    void doAnalysis() {
        String raw = input.getText().trim();

        if (raw.equals("")) {
            output.setText("You didn't type anything!");
            return;
        }

        String[] parts = raw.split(" ");
        int[] nums = new int[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
        } catch (Exception ex) {
            output.setText("Please only type numbers separated by spaces.");
            return;
        }

        int max = nums[0], min = nums[0], total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
            total += nums[i];
        }

        double avg = (double) total / nums.length;

        output.setText("Max: " + max + "\nMin: " + min + "\nAvg: " + String.format("%.2f", avg));
    }

    public static void main(String[] args) {
        new main();
    }
}
