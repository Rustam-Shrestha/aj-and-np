package Labs.FormEventHandling.done;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DelegationEventModelDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Delegation Event Model");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me");

        // Using separate listener class
        button.addActionListener(new ButtonClickListener());

        frame.add(button);
        frame.setVisible(true);
    }
}

        // Custom event handler class
        class ButtonClickListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked from Separate Listener!");
                JOptionPane.showMessageDialog(null, "Event handled in separate class!");
            }
        }