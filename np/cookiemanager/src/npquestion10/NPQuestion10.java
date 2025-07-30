/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion10;
import java.net.*;

public class NPQuestion10 {


    public static void main(String[] args) {
        // TODO code application logic here
        //create instance of cookie manager
        CookieManager cookieManager = new CookieManager();
        
        // set cookieManager cookie policy using setCookiePolicy Method....
        
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        System.out.println("\n\n"+"Cookie Policy for CookieManager is set to : CookiePolicy.ACCEPT_ALL");
    }
    
}
