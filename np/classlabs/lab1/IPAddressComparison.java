package lab1;
import java.net.*;  // Importing the package for networking utilities

public class IPAddressComparison {
    public static void main(String[] args) {
        try {
            // Getting the IP address of the domain "tu.edu.np"
            InetAddress address1 = InetAddress.getByName("tu.edu.np");
            // Getting the IP address of the domain "fohss.tu.edu.np"
            InetAddress address2 = InetAddress.getByName("fohss.tu.edu.np");

            // Printing the IP addresses of the two domains
            System.out.println("IP Address of tu.edu.np: " + address1.getHostAddress());
            System.out.println("IP Address of fohss.tu.edu.np: " + address2.getHostAddress());

            // Comparing the IP addresses to check if they are the same
            if (address1.equals(address2)) {
                System.out.println("Same address");
            } else {
                System.out.println("different address");
            }
            
        } catch (UnknownHostException e) {
            // Handling the exception in case the domain is not found
            System.out.println("Domain not found or cannot be resolved.");
        }
    }
}
