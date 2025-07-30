

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingFormDemo {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("User Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(8, 2, 5, 5)); // Grid layout for form structure

        // Name Label and TextField
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        nameField.setToolTipText("Enter your full name");

        // Password Label and PasswordField
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        passField.setToolTipText("Enter a secure password");

        // Gender Selection using Radio Buttons
        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Country Selection using JComboBox
        JLabel countryLabel = new JLabel("Country:");
        String[] countries = {"Select", "USA", "UK", "India", "Canada"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        countryBox.setToolTipText("Select your country");

        // Address Label and TextArea
        JLabel addressLabel = new JLabel("Address:");
        JTextArea addressArea = new JTextArea(3, 20);
        addressArea.setToolTipText("Enter your complete address");

        // Terms and Conditions using CheckBox
        JCheckBox termsCheckBox = new JCheckBox("I accept the terms and conditions");
        termsCheckBox.setToolTipText("You must accept to proceed");

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setToolTipText("Click to submit the form");

        // ActionListener to handle form submission
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collecting user input
                String name = nameField.getText();
                String password = new String(passField.getPassword()); // Convert char[] to String
                String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not Selected");
                String country = (String) countryBox.getSelectedItem();
                String address = addressArea.getText();
                boolean acceptedTerms = termsCheckBox.isSelected();

                // Validation Check
                if (name.isEmpty() || password.isEmpty() || country.equals("Select") || address.isEmpty() || !acceptedTerms) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields and accept the terms!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Display Data in Console
                    System.out.println("=== Form Submission ===");
                    System.out.println("Name: " + name);
                    System.out.println("Password: " + password);
                    System.out.println("Gender: " + gender);
                    System.out.println("Country: " + country);
                    System.out.println("Address: " + address);
                    System.out.println("Accepted Terms: " + (acceptedTerms ? "Yes" : "No"));
                    
                    JOptionPane.showMessageDialog(frame, "Form submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Adding Components to Frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(genderLabel);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);
        frame.add(countryLabel);
        frame.add(countryBox);
        frame.add(addressLabel);
        frame.add(new JScrollPane(addressArea)); // Add ScrollPane for large text
        frame.add(new JLabel()); // Empty space
        frame.add(termsCheckBox);
        frame.add(new JLabel()); // Empty space
        frame.add(submitButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}
