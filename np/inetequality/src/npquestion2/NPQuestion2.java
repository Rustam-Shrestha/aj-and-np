/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion2;
import java.net.InetAddress;
public class NPQuestion2 {

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            InetAddress ip = InetAddress.getByName("www.javatpoint.com");
            InetAddress ip2 = InetAddress.getByName("www.facebook.com");
            
            System.out.println("Host Name 1:" +ip.getHostName());
             System.out.println("Host Name 2:" +ip2.getHostName());
             
             if(ip.equals(ip2))
             {
                 System.out.println("\n\nBoth inet address are equal.");
             }
             
             else
             {
                 System.out.println("\n\nBoth inet address are not equal.");
             }
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
