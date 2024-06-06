package TugasGUI;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Add the calculator panel
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setVisible(true);
        });
    }
}

