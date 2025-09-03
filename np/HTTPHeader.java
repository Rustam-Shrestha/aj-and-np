import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HTTPHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.instagram.com"); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            for (Map.Entry<String, java.util.List<String>> entry : conn.getHeaderFields().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
