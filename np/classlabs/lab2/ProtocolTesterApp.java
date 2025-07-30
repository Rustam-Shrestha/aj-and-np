import javax.swing.*;  
import java.awt.*;  
import java.net.*;  

/**  
 * This program tests which URL protocols are supported by Java.  
 */  
public class ProtocolTesterApp {  

    public static void main(String[] args) {  
        // Create and display the GUI on the Event Dispatch Thread  
        SwingUtilities.invokeLater(() -> createAndShowGUI());  
    }  

    /**  
     * Creates and displays the main application window.  
     */  
    private static void createAndShowGUI() {  
        JFrame frame = new JFrame("Protocol Tester");  // Create a window  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close on exit  
        frame.setSize(400, 400);  // Set window size  

        JTextArea results = new JTextArea();  // Create a text area  
        results.setEditable(false);  // Make it read-only  
        frame.add(new JScrollPane(results), BorderLayout.CENTER);  // Add scrollable text area  

        frame.setVisible(true);  // Show the window  

        testProtocols(results);  // Run protocol tests  
    }  

    /**  
     * Tests various URL protocols and updates the results area.  
     */  
    private static void testProtocols(JTextArea results) {  
        String host = "https://www.peacefire.org";  // Full URL required  
        
        // List of different URL schemes to test  
        String[] schemes = {  
            "http", "https", "ftp", "mailto", "telnet", "file", "ldap",  
            "gopher", "jdbc", "rmi", "jndi", "jar",  
            "doc", "netdoc", "nfs", "verbatim",  
            "finger", "daytime", "systemresource"  
        };  

        for (String scheme : schemes) {  
            try {  
                // Create a valid URL  
                URL u = new URL(scheme + "://" + host);  
                results.append(scheme + " is supported\n");  
            } catch (MalformedURLException ex) {  
                results.append(scheme + " is not supported\n");  
            }  
        }  
    }  
}  
