/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion3;
import java.net.*;

public class NPQuestion3 {

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            InetAddress add = InetAddress.getByName("www.javatpoint.com");
            System.out.println("Name is :"+add.getHostName());
            System.out.println("Address is :"+add.getHostAddress());
            System.out.println(add.isAnyLocalAddress());
            System.out.println(add.isLinkLocalAddress());
            System.out.println(add.hashCode());
            System.out.println(add.isMulticastAddress());
            System.out.println(add.isMCGlobal());
            System.out.println(add.isMCOrgLocal());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
