

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Random;

public class InteractiveSwingForm {
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("Interactive Swing Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(0, 2, 10, 10));

        // Name Field
        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        // Password Field
        frame.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        JLabel strengthLabel = new JLabel("Weak");
        frame.add(passwordField);
        frame.add(strengthLabel);

        // Password Strength Checker (KeyListener)
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String pass = new String(passwordField.getPassword());
                if (pass.length() < 5) strengthLabel.setText("Weak");
                else if (pass.length() < 8) strengthLabel.setText("Medium");
                else strengthLabel.setText("Strong");
            }
        });

        // Mood Slider
        frame.add(new JLabel("Mood Slider:"));
        JLabel moodLabel = new JLabel("Neutral");
        JSlider moodSlider = new JSlider(0, 10, 5);
        moodSlider.setPaintTicks(true);
        moodSlider.setPaintLabels(true);
        frame.add(moodSlider);
        frame.add(moodLabel);

        // Mood Slider Change (ChangeListener)
        moodSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = moodSlider.getValue();
                if (value < 4) moodLabel.setText("Angry");
                else if (value < 7) moodLabel.setText("Neutral");
                else moodLabel.setText("Happy");
            }
        });

        // File Chooser Button
        frame.add(new JLabel("Upload File:"));
        JButton fileButton = new JButton("Choose File");
        JLabel fileReaction = new JLabel("File");
        frame.add(fileButton);
        frame.add(fileReaction);

        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Images & Text Files", "jpg", "png", "txt"));
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    String fileName = fileChooser.getSelectedFile().getName();
                    if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                        fileReaction.setText("Nice Pic!");
                    } else if (fileName.endsWith(".txt")) {
                        fileReaction.setText("Reading...");
                    } else {
                        fileReaction.setText("What is this?");
                    }
                }
            }
        });

        // Submit Button
        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);

        // Submit Button Action (ActionListener)
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String pass = new String(passwordField.getPassword());
                if (name.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Fill all fields first!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Hello " + name + "! Form Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.getContentPane().setBackground(new Color(new Random().nextInt(0xFFFFFF)));
                }
            }
        });

        frame.setVisible(true);
    }
}
