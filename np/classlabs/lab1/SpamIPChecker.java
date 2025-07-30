package lab1;
import java.net.*;  
import java.util.Scanner;

public class SpamIPChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  // Auto-closing scanner
            System.out.print("Enter an IP address to check for spam: ");
            String ipAddress = scanner.nextLine();

            String reversedIP = reverseIP(ipAddress);
            String blacklistHost = reversedIP + ".zen.spamhaus.org";

            if (isBlacklisted(blacklistHost)) {
                System.out.println("SPAM.");
            } else {
                System.out.println("not SPAM.");
            }
        }
    }

    private static String reverseIP(String ip) {
        String[] parts = ip.split("\\.");
        return String.join(".", parts[3], parts[2], parts[1], parts[0]);  // Optimized reversal
    }

    private static boolean isBlacklisted(String blacklistHost) {
        try {
            InetAddress.getByName(blacklistHost);
            return true;  // If resolved, it's blacklisted
        } catch (UnknownHostException e) {
            return false; // If lookup fails, it's not blacklisted
        }
    }
}




//java spamipchecker.java

/* 
 * User Input: The program asks the user to enter an IP address.
Reverse IP: It reverses the IP address for DNSBL lookup (Blacklist checking services require reversed IP format).
Blacklist Query: It appends the reversed IP to a DNSBL (Spamhaus zen.spamhaus.org used as an example).
DNS Lookup: It performs a lookup for the reversed IP on the blacklist.
If a valid response is received, the IP is blacklisted as SPAM.
If the lookup fails (UnknownHostException), the IP is not blacklisted.

 * 
*/