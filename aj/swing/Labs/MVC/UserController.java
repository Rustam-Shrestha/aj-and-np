package Labs.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;

        // Button Listeners
        view.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFormSubmission();
            }
        });

        view.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }

    private void handleFormSubmission() {
        // Get data from the view
        String firstName = view.firstNameField.getText();
        String lastName = view.lastNameField.getText();
        String ageText = view.ageField.getText();
        String gender = (String) view.genderComboBox.getSelectedItem();
        boolean isSubscribed = view.subscribeYes.isSelected();

        // Validation: Check if fields are empty
        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            model.setFirstName(firstName);
            model.setLastName(lastName);
            model.setAge(age);
            model.setGender(gender);
            model.setSubscribed(isSubscribed);

            // Update View
            view.displayArea.setText(model.getUserDetails());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Age must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        view.firstNameField.setText("");
        view.lastNameField.setText("");
        view.ageField.setText("");
        view.genderComboBox.setSelectedIndex(0);
        view.subscribeNo.setSelected(true);
        view.displayArea.setText("");
    }

    public static void main(String[] args) {
        UserModel model = new UserModel();
        UserView view = new UserView();
        new UserController(model, view);
    }
}
