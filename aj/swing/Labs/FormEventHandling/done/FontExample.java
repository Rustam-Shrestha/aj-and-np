package Labs.FormEventHandling.done;

import javax.swing.*;
import java.awt.*;

public class FontExample extends JFrame {
    public FontExample() {
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Bold Font");
        label1.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel label2 = new JLabel("Italic Font");
        label2.setFont(new Font("Times New Roman", Font.ITALIC, 20));

        // JLabel label3 = new JLabel("Plain Font");
        // label3.setFont(new Font("Courier New", Font.PLAIN, 20));

        add(label1);
        add(label2);
        // add(label3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FontExample();
    }
}

