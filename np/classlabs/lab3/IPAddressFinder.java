import java.net.*;  // Importing the package for networking utilities
import java.util.Scanner;

public class IPAddressFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Creating a Scanner object for user input
        System.out.print("Enter the host address: ");  // Prompting the user to enter the host address
        String hostAddress = scanner.nextLine();  // Reading the user input
        
        try {
            // Getting all IP addresses associated with the host
            InetAddress[] addresses = InetAddress.getAllByName(hostAddress);
            
            // Iterating over each IP address
            for (InetAddress address : addresses) {
                // Printing the IP address
                System.out.println("IP Address: " + address.getHostAddress());
                
                // Checking whether the IP address is IPv4 or IPv6
                if (address instanceof Inet4Address) {
                    System.out.println("This is an IPv4 address.");
                } else if (address instanceof Inet6Address) {
                    System.out.println("This is an IPv6 address.");
                } else {
                    System.out.println("Unknown IP type.");
                }
            }
            
        } catch (UnknownHostException e) {
            // Handling the exception in case the domain is not found
            System.out.println("Domain not found or cannot be resolved.");
        }

        scanner.close();  // Closing the Scanner object
    }
}
