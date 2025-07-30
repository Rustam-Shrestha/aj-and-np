/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Waiting for client");
            Socket server = ss.accept();
            System.out.println("Connection Established.......");
        }
        
         catch(Exception e)
         {
             System.out.println(e);
         }
    }   
}
