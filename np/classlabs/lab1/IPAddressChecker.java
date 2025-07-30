package lab1;
import java.net.*;  // Importing the package for networking utilities
import java.util.Scanner;

public class IPAddressChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("host address: ");
        String hostAddress = scanner.nextLine();
        
        try {
            // Getting the IP address of the domain entered by the user
            InetAddress address = InetAddress.getByName(hostAddress);
            
            // Printing the IP address
            System.out.println("IP Address: " + address.getHostAddress());
            
            // Checking whether the IP address is IPv4 or IPv6
            if (address instanceof Inet4Address) {
                System.out.println("It is an IPv4 address.");
            } else if (address instanceof Inet6Address) {
                System.out.println("It is an IPv6 address.");
            } else {
                System.out.println("Unknown IP type.");
            }
            
            // Getting the local machine's name and IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local Host IP Address: " + localHost.getHostAddress());
            
        } catch (UnknownHostException e) {
            // Handling the exception in case the domain is not found
            System.out.println("Domain not found");
        }

        scanner.close();
    }
}

// java ipaddresschecker.java
