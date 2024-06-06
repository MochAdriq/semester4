package TugasGUI;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanel extends JPanel {
    public CalculatorPanel() {
        setLayout(new BorderLayout());

        // Create display field
        JTextField displayField = new JTextField();
        add(displayField, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 6)); // 4 rows, 5 columns

        // Add buttons to the panel
        String[] buttonLabels = {
            "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0", "+", "-",
            "*", "/", "=", "%", "Mod", "Exit"
        };

        for (String label : buttonLabels) {
            CalculatorButton button = new CalculatorButton(label);
            buttonPanel.add(button);

            // Add action listener to the "Exit" button
            if (label.equals("Exit")) {
                button.addActionListener(e -> System.exit(0));
            }
        }

        add(buttonPanel, BorderLayout.CENTER);
    }
}
