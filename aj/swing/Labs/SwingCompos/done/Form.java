package Labs.SwingCompos.done;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
// import java.awt.event.*;
import java.text.NumberFormat;
// import java.util.Date;0000000

public class Form {
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("Swing Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(0, 2, 10, 10));

        // Text Field
        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        // Password Field
        frame.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        frame.add(passwordField);

        // Number Field
        frame.add(new JLabel("Age:"));
        JFormattedTextField ageField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        frame.add(ageField);

        // Checkbox
        frame.add(new JLabel("Subscribe:"));
        JCheckBox subscribeBox = new JCheckBox("Yes");
        frame.add(subscribeBox);

        // Radio Buttons
        frame.add(new JLabel("Gender:"));
        JPanel radioPanel = new JPanel(new FlowLayout());
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        radioPanel.add(male);
        radioPanel.add(female);
        frame.add(radioPanel);

        // Dropdown
        frame.add(new JLabel("Country:"));
        String[] countries = {"USA", "UK", "Canada", "Nepal"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        frame.add(countryBox);

        // Spinner
        frame.add(new JLabel("Quantity:"));
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        frame.add(quantitySpinner);

        // Slider
        frame.add(new JLabel("Satisfaction Level:"));
        JSlider slider = new JSlider(0, 10, 5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(1);
        frame.add(slider);

        // Text Area
        frame.add(new JLabel("Feedback:"));
        JTextArea feedbackArea = new JTextArea(3, 20);
        frame.add(new JScrollPane(feedbackArea));

        // File Chooser Button
        frame.add(new JLabel("Upload File:"));
        JButton fileButton = new JButton("Choose File");
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Images & Text Files", "jpg", "png", "txt"));
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(frame, "Selected: " + fileChooser.getSelectedFile().getName());
            }
        });
        frame.add(fileButton);

        // Color Chooser Button
        frame.add(new JLabel("Choose Color:"));
        JButton colorButton = new JButton("Pick Color");
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(frame, "Pick a Color", Color.BLACK);
            if (color != null) {
                frame.getContentPane().setBackground(color);
            }
        });
        frame.add(colorButton);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Form Submitted!"));
        frame.add(submitButton);

        // Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            nameField.setText("");
            passwordField.setText("");
            ageField.setText("");
            subscribeBox.setSelected(false);
            genderGroup.clearSelection();
            countryBox.setSelectedIndex(0);
            quantitySpinner.setValue(1);
            slider.setValue(5);
            feedbackArea.setText("");
        });
        frame.add(resetButton);

        // Show frame
        frame.setVisible(true);
    }
}
