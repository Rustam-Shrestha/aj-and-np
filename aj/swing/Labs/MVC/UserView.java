package Labs.MVC;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    JTextField firstNameField, lastNameField, ageField;
    JComboBox<String> genderComboBox;
    JRadioButton subscribeYes, subscribeNo;
    JButton submitButton, clearButton;
    JTextArea displayArea;

    public UserView() {
        setTitle("User Registration");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Labels
        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Gender:"));
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        add(genderComboBox);

        // Subscription Radio Buttons
        add(new JLabel("Subscribe:"));
        JPanel subscriptionPanel = new JPanel();
        subscribeYes = new JRadioButton("Yes");
        subscribeNo = new JRadioButton("No", true);
        ButtonGroup group = new ButtonGroup();
        group.add(subscribeYes);
        group.add(subscribeNo);
        subscriptionPanel.add(subscribeYes);
        subscriptionPanel.add(subscribeNo);
        add(subscriptionPanel);

        // Buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        add(submitButton);
        add(clearButton);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        setVisible(true);
    }
}

