/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipaddresscheck;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressCheck 
{

    public static void main(String[] args) 
    {
         String domain = "fohss.tu.edu.np";

        try {
            // Let's get the IP address of the domain
            InetAddress inetAddress = InetAddress.getByName(domain);
            String ipAddress = inetAddress.getHostAddress();

            // Print the IP address ...........
            System.out.println("Domain: " + domain);
            System.out.println("IP Address: " + ipAddress);

            // Okay lets check whether it is IPv4 or IPv6 ...................
            if (ipAddress.contains(":")) 
            {
                System.out.println("The IP address is IPv6.");
            } 
            else if (ipAddress.contains(".")) 
            {
                System.out.println("The IP address is IPv4.");
            }
            
            else 
            {
                System.out.println("Unable to determine the IP address type.");
            }
        } catch (UnknownHostException e) 
        {
            System.out.println("Error: Unable to resolve the domain name.");
        }
    }
}