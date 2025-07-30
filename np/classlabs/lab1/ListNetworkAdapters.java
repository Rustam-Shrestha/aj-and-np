package lab1;
import java.net.*; // Importing the package for networking utilities
import java.util.Enumeration;

public class ListNetworkAdapters {
    public static void main(String[] args) {
        try {
            // Getting an enumeration of all the network interfaces (adapters)
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            // Iterating over each network interface
            while (interfaces.hasMoreElements()) {
                // Getting the next network interface
                NetworkInterface networkInterface = interfaces.nextElement();
                
                // Printing the name of the network interface
                System.out.println("Name: " + networkInterface.getName());
                
                // Printing the display name of the network interface
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                
                // Adding a separator for readability
                System.out.println("---------------------------");
            }
        } catch (SocketException e) {
            // Handling the exception in case there is a socket error
            System.out.println("Error occurred while retrieving network interfaces: " + e.getMessage());
        }
    }
}

//java listnetworkadapters.java