
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventDemo {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Button Click Event");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button
        JButton button = new JButton("Click Me");

        // Add ActionListener to handle button click
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!"); // Print message in console
                JOptionPane.showMessageDialog(frame, "Button was clicked!");
            }
        });

        // Add button to frame
        frame.add(button);
        frame.setVisible(true);
    }
}
