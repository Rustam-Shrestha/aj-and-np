/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion7;
import java.net.*;

public class NPQuestion7 {

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            URL www = new URL("http://www.ibiblio.org");
             URL ibiblio = new URL("http://ibiblio.org");
             
             if(ibiblio.equals(www))
             {
                 System.out.println("\n\n"+ibiblio +" is the same as "+www);
             }
             
             else
             {
                  System.out.println("\n\n"+ibiblio +" is not the same as "+www);
             }
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
