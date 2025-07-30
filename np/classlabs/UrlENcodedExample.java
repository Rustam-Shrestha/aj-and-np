import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.MalformedInputException;
import java.net.URLDecoder;

public class UrlENcodedExample {

    public static void main(String[] args) throws MalformedURLException {
         String baseURL = "https://www.kathkhabar.com/?q=";
         String query = "info@gmail.com for bca";

        System.out.println("URL without encoding");

        URL url = new URL(baseURL + query);
        
        System.out.println(url);

        
        try {
            System.out.println("URL after encoding");
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            url = new URL(baseURL + encodedQuery);
            System.out.println(url);
            System.out.println("URL after decoding");
            String decodedQuery = URLDecoder.decode(encodedQuery, "UTF-8");
            url = new URL(baseURL + decodedQuery);
            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}