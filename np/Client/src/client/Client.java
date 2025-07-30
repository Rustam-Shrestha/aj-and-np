/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;
import java.net.*;
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try{
            System.out.println("Client Started.");
            Socket client = new Socket("localhost", 5000);
            System.out.println("Client is connected");
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
