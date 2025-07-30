

import javax.swing.*;

public class ImageDisplay {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load image (Ensure image exists in the project directory)
        ImageIcon image = new ImageIcon("example.png");
        JLabel label = new JLabel(image);

        frame.add(label);
        frame.setVisible(true);
    }
}

