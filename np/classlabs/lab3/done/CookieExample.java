package done;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;

public class CookieExample {

    public static void main(String[] args) throws Exception {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();
        
        // Define a URI for the cookie
        URI uri = new URI("http://example.com");

        // Set a cookie
        HttpCookie cookie = new HttpCookie("sessionID", "12345");
        cookie.setPath("/");
        cookie.setMaxAge(3600); 
        cookieStore.add(uri, cookie);
        System.out.println("Cookie set: " + cookie);

        
        System.out.println("Cookies stored:");
        for (HttpCookie storedCookie : cookieStore.get(uri)) {
            System.out.println(storedCookie);
        }

        // Unset (remove) the cookie
        cookieStore.remove(uri, cookie);
        System.out.println("Cookie removed.");
        
        // Verify the removal
        System.out.println("Cookies after removal:");
        for (HttpCookie storedCookie : cookieStore.get(uri)) {
            System.out.println(storedCookie);
        }
    }
}
