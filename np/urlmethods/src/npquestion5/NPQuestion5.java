/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion5;
import java.net.*;

public class NPQuestion5 {

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            URL url = new URL("https://www.youtube.com/watch?v=rJEB-oyCjKw");
            
            System.out.println("Protocol :"+url.getProtocol()); 
            System.out.println("Host Name :"+url.getHost());     
            System.out.println("Port Number :"+url.getPort());
            System.out.println("File Name :"+url.getFile());
            System.out.println("Query is :"+url.getQuery());
            System.out.println("Default Port is :"+url.getDefaultPort());
            System.out.println("String is :"+url.toString());
            System.out.println("Path is :"+url.getPath());
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
    
}
