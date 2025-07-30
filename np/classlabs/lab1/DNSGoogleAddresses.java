package lab1;
import java.net.*;  // Importing the package for networking utilities

public class DNSGoogleAddresses {
    public static void main(String[] args) {
        try {
            // Getting all IP addresses associated with "dns.google.com"
            InetAddress[] addresses = InetAddress.getAllByName("dns.google.com");
            
            // Printing all resolved IP addresses
            System.out.println("All IP addresses of dns.google.com:");
            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            // Handling the exception in case the domain cannot be resolved
            System.out.println("Domain not found or cannot be resolved.");
        }
    }
}

// java dnsgoogleaddresses.java