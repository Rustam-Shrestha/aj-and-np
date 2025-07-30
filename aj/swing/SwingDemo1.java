
import javax.swing.*; // Import Swing components
import java.awt.*; // Import AWT for layout and colors
import java.util.Timer; 
import java.util.TimerTask;

public class SwingDemo1 {
    public static void main(String[] args) {
        // Show splash screen for 3 seconds before launching main frame
        showSplashScreen();
    }

    // Method to create and display a JWindow (Splash Screen)
    private static void showSplashScreen() {
        JWindow splash = new JWindow(); // JWindow has no title bar
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to Swing Demo", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(label, BorderLayout.CENTER);
        splash.add(panel);
        
        splash.setSize(300, 150); // Set window size
        splash.setLocationRelativeTo(null); // Center on screen
        splash.setVisible(true); // Show window

        // Close splash screen after 3 seconds and open main JFrame
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                splash.dispose(); // Close splash screen
                showMainFrame(); // Open main JFrame
            }
        }, 5000); // 3000 milliseconds = 3 seconds
    }

    // Method to create and display the main JFrame
    private static void showMainFrame() {
        JFrame frame = new JFrame("Swing Components Demo"); // Create JFrame with title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
        frame.setSize(400, 300); // Set size
        frame.setLocationRelativeTo(null); // Center on screen

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Set layout manager

        // Load an icon and create a JLabel with it
        ImageIcon icon = new ImageIcon("icon.png"); // Ensure "icon.png" exists in your project folder
        JLabel label = new JLabel("Hello, Swing!", icon, JLabel.CENTER);

        // Add label to panel
        panel.add(label);

        // Add panel to frame
        frame.add(panel);

        // Show frame
        frame.setVisible(true);
    }
}
