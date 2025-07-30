/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion15;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NPQuestion15 {

    public static void main(String[] args) {
        String urlhost="www.javatpoint.com";
        // TODO code application logic here
        try{
            Socket thesocket = new Socket(urlhost,80);
            System.out.println("\n\nConnected to :"+thesocket.getInetAddress()+"\t\n\n on port :"+thesocket.getPort()+"\t\n\n from port :"+thesocket.getLocalPort()+"\t\n\n of : "+thesocket.getLocalAddress());
        }
        
        catch(UnknownHostException ex)
        {
            System.err.println("I can't find"+urlhost);
        }
        catch(SocketException ex)
        {
            System.err.println("Couldn't connect to "+urlhost);
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
    
}
