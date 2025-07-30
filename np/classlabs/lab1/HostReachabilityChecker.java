package lab1;
import java.net.*;  // Importing the package for networking utilities
import java.util.Scanner;

public class HostReachabilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Creating a Scanner object for user input
        System.out.print("Enter the host address: ");  // Prompting the user to enter the host address
        String hostAddress = scanner.nextLine();  // Reading the user input

        try {
            // Getting the IP address of the domain entered by the user
            InetAddress address = InetAddress.getByName(hostAddress);

            // Checking if the host is reachable with a timeout of 5000 milliseconds (5 seconds)
            boolean reachable = address.isReachable(5000);

            // Printing the reachability status
            if (reachable) {
                System.out.println("The host " + hostAddress + " is reachable.");
            } else {
                System.out.println("The host " + hostAddress + " is not reachable.");
            }
        } catch (UnknownHostException e) {
            // Handling the exception in case the domain is not found
            System.out.println("Domain not found or cannot be resolved.");
        } catch (Exception e) {
            // Handling the exception in case there is an I/O error
            System.out.println("I/O error occurred while checking reachability: " + e.getMessage());
        } finally {
            scanner.close();  // Closing the Scanner object in a finally block to ensure it gets closed
        }
    }
}


// java hostreachabilitychecker.java