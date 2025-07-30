/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion13;
import java.io.*;
import java.net.*;

public class NPQuestion13 {

    public static void main(String[] args) {
        // TODO code application logic here
        try{
            URL url = new URL("https://www.tufohss.edu.np");
            HttpURLConnection huc = (HttpURLConnection)url.openConnection();
            
            for(int i =1; i<=8; i++)
            {
                System.out.println(huc.getHeaderFieldKey(i)+"="+huc.getHeaderField(i));
            }
            
            huc.disconnect();
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
