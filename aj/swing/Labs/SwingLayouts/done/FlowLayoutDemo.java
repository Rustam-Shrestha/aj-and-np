package Labs.SwingLayouts.done;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // FlowLayout with center alignment
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        for (int i = 1; i <= 14; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setVisible(true);
    }
}
