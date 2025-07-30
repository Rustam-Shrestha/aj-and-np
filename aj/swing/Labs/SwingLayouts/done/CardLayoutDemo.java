package Labs.SwingLayouts.done;

import javax.swing.*;
import java.awt.*;


public class CardLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Add different panels (cards)
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is Card 1"));
        panel1.setBackground(Color.CYAN);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Card 2"));
        panel2.setBackground(Color.ORANGE);

        cardPanel.add(panel1, "Card1");
        cardPanel.add(panel2, "Card2");

        // Buttons to switch cards
        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> cardLayout.next(cardPanel));

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(nextButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
