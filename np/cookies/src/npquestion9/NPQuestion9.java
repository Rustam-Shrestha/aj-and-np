/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package npquestion9;
import java.io.*;
import java.net.*;
import java.util.*;

public class NPQuestion9 {


    public static void main(String[] args) {
        // TODO code application logic here
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();
        
        //creating cookies and URI
        HttpCookie cookieA = new HttpCookie("c1", "anish");
        HttpCookie cookieB = new HttpCookie("c2", "roshan");
        HttpCookie cookieC = new HttpCookie("c3", "prajol");
        
        URI uri1 = URI.create("https://test1.com/");
         URI uri2 = URI.create("https://test2.com/");
         
         //Add cookies in cookieStore
         cookieStore.add(uri1, cookieA);
         cookieStore.add(uri2, cookieB);
         cookieStore.add(null, cookieC);
         
         //Read stored all cookies
         List cookieList = cookieStore.getCookies();
         System.out.println("\n\n"+"Cookies List in cookieStore is : \n"+cookieList+"\n");
         
         //remove cookie of uri
         cookieStore.remove(uri1, cookieA);
         List remainingCookieList = cookieStore.getCookies();
         System.out.println("\n\n"+"Remaining Cookies is :\n"+remainingCookieList+"\n");
         
         
         //remove all cookies 
         cookieStore.removeAll();
         List EmptyCookieList = cookieStore.getCookies();
         System.out.println("\n\n"+"Empty Coookies :\n"+EmptyCookieList);
    }
    
}
