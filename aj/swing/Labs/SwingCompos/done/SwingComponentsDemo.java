package Labs.SwingCompos.done;


import javax.swing.*;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class SwingComponentsDemo {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Components Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        // ======= MENU BAR CREATION =======
        JMenuBar menuBar = new JMenuBar();  // Create a menu bar
        JMenu fileMenu = new JMenu("File"); // Create a "File" menu
        JMenuItem exitMenuItem = new JMenuItem("Exit"); // Create an "Exit" option

        // Exit action - Closes the application
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem); // Add exit option to the "File" menu
        menuBar.add(fileMenu); // Add "File" menu to menu bar
        frame.setJMenuBar(menuBar); // Set menu bar to the frame

        // ======= TABBED PANE CREATION =======
        JTabbedPane tabbedPane = new JTabbedPane(); // Create a tabbed pane

        // ======= PANEL 1: FORM INPUT =======
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextArea addressArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(addressArea); // Add scroll to textarea
        JButton submitButton = new JButton("Submit");

        // ActionListener to capture and display form data
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String address = addressArea.getText();

            // Display user input in console
            System.out.println("=== User Input ===");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Address: " + address);

            // Show confirmation dialog
            JOptionPane.showMessageDialog(frame, "Form Submitted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // Add components to the form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(addressLabel);
        formPanel.add(scrollPane);
        formPanel.add(new JLabel()); // Empty cell
        formPanel.add(submitButton);

        // ======= PANEL 2: DIALOG BUTTONS =======
        JPanel dialogPanel = new JPanel(new FlowLayout());

        JButton infoButton = new JButton("Show Info");
        JButton confirmButton = new JButton("Confirm Action");

        // Show an information dialog
        infoButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "This is an Information Message", "Info", JOptionPane.INFORMATION_MESSAGE));

        // Show a confirmation dialog
        confirmButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame, "Do you want to proceed?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.out.println("User confirmed: YES");
            } else {
                System.out.println("User confirmed: NO");
            }
        });

        // Add buttons to dialog panel
        dialogPanel.add(infoButton);
        dialogPanel.add(confirmButton);

        // ======= ADD PANELS TO TABS =======
        tabbedPane.addTab("User Form", formPanel);
        tabbedPane.addTab("Dialogs", dialogPanel);

        // Add tabbed pane to the frame
        frame.add(tabbedPane);

        // Set frame visibility
        frame.setVisible(true);
    }
}
