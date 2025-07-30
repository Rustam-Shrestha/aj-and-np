import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale; // ✅ Add this import

public class URLDetails {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://kathkhabar.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // Format current time
            long accessTime = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
            String formattedDate = sdf.format(new Date(accessTime));

            // Display headers
            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content-Length: " + connection.getContentLength());
            System.out.println("Last-Modified: " + connection.getLastModified());
            System.out.println("Expiration: " + connection.getExpiration());
            System.out.println("Access Date: " + formattedDate);

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
