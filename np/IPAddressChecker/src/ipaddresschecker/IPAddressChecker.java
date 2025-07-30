/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipaddresschecker;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressChecker {

    public static void main(String[] args) {
        String domain = "fohss.tu.edu.np";
        
        try {
            // Get the InetAddress for the domain
            InetAddress inetAddress = InetAddress.getByName(domain);
            
            // Get the IP address as a string
            String ipAddress = inetAddress.getHostAddress();
            System.out.println("IP Address of " + domain + ": " + ipAddress);
            
            // Check if the IP address is IPv4 or IPv6
            if (inetAddress instanceof java.net.Inet4Address) {
                System.out.println(ipAddress + " is an IPv4 address.");
            } else if (inetAddress instanceof java.net.Inet6Address) {
                System.out.println(ipAddress + " is an IPv6 address.");
            } else {
                System.out.println("Unknown IP address type.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve the domain: " + e.getMessage());
        }
    }
}

