/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion8;
import java.net.*;

public class NPQuestion8 {


    public static void main(String[] args) throws URISyntaxException {
        // TODO code application logic here
        URI uri1 = new URI("http://www.google.com");
        URI uri2 = new URI("URN:ISBN:0-395-36341-1");
        
        System.out.println(uri1);
        System.out.println("Authority :"+uri1.getAuthority());
        System.out.println("Fragment :"+uri1.getFragment());
        System.out.println("Host :"+uri1.getHost());
        System.out.println("Scheme :"+uri1.getScheme());
        System.out.println("Port :"+uri1.getPort());
        
        System.out.println("\n\n"+uri2);
        System.out.println("Authority :"+uri2.getAuthority());
        System.out.println("Fragment :"+uri2.getFragment());
        System.out.println("Host :"+uri2.getHost());
        System.out.println("Scheme :"+uri2.getScheme());
        System.out.println("Port :"+uri2.getPort());
    }
    
}
