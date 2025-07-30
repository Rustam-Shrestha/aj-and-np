/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion16;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;

public class NPQuestion16 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ServerSocket serverSocket = new ServerSocket(0);
            System.out.println("\n\nServer is running on port :"+serverSocket.getLocalPort());
            
            //print the inetAddress Information
            InetAddress inetAddress = serverSocket.getInetAddress();
            System.out.println("\nInetAddress is : "+inetAddress.getHostAddress());
            System.out.println("\nCanonical Host Name is : "+inetAddress.getCanonicalHostName());
            System.out.println("\nHost Name is : "+inetAddress.getHostName());
        }
        
        catch(IOException ex)
        {
            System.out.println("Server Exception"+ex.getMessage());
        }
    }
    
}
