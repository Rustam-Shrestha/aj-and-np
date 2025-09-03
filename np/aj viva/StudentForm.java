
import javax.swing.*;
import java.awt.GridLayout;

public class StudentForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Form");
        f.setSize(300, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(6, 2));

        String[] labels = {"Name", "Roll No", "Department", "Email", "Phone"};
        JTextField[] fields = new JTextField[5];

        for (int i = 0; i < 5; i++) {
            f.add(new JLabel(labels[i]));
            fields[i] = new JTextField();
            f.add(fields[i]);
        }

        JButton submit = new JButton("Submit");
        f.add(submit);
        f.add(new JLabel()); // empty cell

        submit.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Student Details:\n");
            for (int i = 0; i < 5; i++)
                sb.append(labels[i]).append(": ").append(fields[i].getText()).append("\n");
            JOptionPane.showMessageDialog(f, sb.toString());
        });

        f.setVisible(true);
    }
}
