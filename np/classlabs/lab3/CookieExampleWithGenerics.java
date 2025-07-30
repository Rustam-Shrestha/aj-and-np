import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CookieExampleWithGenerics {
    public static void main(String[] args) throws Exception {
        // Create a CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Define a URI for the cookies
        URI uri = new URI("http://example.com");

        // Create a list of cookies using generics
        List<HttpCookie> cookieList = new ArrayList<>();
        cookieList.add(new HttpCookie("sessionID", "12345"));
        cookieList.add(new HttpCookie("userPref", "darkMode"));
        cookieList.add(new HttpCookie("token", "abc123"));

        // Set cookies
        for (HttpCookie cookie : cookieList) {
            cookie.setPath("/");
            cookie.setMaxAge(3600); // Expires in 1 hour
            cookieStore.add(uri, cookie);
        }
        System.out.println("Cookies set successfully.");

        // Display all cookies
        System.out.println("\nCookies stored:");
        for (HttpCookie storedCookie : cookieStore.get(uri)) {
            System.out.println(storedCookie);
        }

        // Unset (remove) all cookies
        for (HttpCookie cookie : cookieList) {
            cookieStore.remove(uri, cookie);
        }
        System.out.println("\nAll cookies removed.");

        // Verify the removal
        System.out.println("\nCookies after removal:");
        for (HttpCookie storedCookie : cookieStore.get(uri)) {
            System.out.println(storedCookie);
        }
    }
}
