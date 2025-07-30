package lab1;
import java.net.*;  // Importing the package for networking utilities
import java.util.Scanner; // Importing Scanner for user input

public class CanonicalHostNameFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creating a Scanner object for input
        
        // Prompting user for an IP address
        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();
        
        try {
            // Getting the InetAddress object from the given IP
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            
            // Printing the canonical host name
            System.out.println("Canonical Host Name: " + inetAddress.getCanonicalHostName());
        } catch (UnknownHostException e) {
            // Handling the exception in case the IP address cannot be resolved
            System.out.println("Invalid IP address or cannot be resolved.");
        }
        
        scanner.close(); // Closing the scanner
    }
}

//java canonicalhostnamefinder.java