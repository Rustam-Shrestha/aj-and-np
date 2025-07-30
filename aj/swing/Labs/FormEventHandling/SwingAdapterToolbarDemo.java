package Labs.FormEventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAdapterToolbarDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Adapter & JToolBar Example");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JToolBar toolBar = new JToolBar();
        JButton newButton = new JButton("New");
        // JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");

        newButton.setToolTipText("Create a new file");
        // openButton.setToolTipText("Open an existing file");
        saveButton.setToolTipText("Save the current file");

        toolBar.add(newButton);
        // toolBar.add(openButton);
        toolBar.add(saveButton);
        toolBar.add(new JSeparator());
        toolBar.add(new JLabel("Toolbar Example"));

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }
        });

        ImageIcon image = new ImageIcon("example.png");
        JLabel label = new JLabel(image);

        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}