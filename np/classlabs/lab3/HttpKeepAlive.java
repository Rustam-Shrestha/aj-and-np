import java.net.HttpURLConnection;
import java.net.URL;

public class HttpKeepAliveDemo {
    public static void main(String[] args) {
        try {
            // Set the URL you want to connect to
            URL url = new URL("http://example.com");

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Enable Keep-Alive (default is true in HttpURLConnection)
            connection.setRequestProperty("Connection", "keep-alive");

            // Set other request properties (optional)
            connection.setRequestMethod("GET");

            // Read the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Print a header to show Keep-Alive is enabled
            String keepAliveHeader = connection.getHeaderField("Connection");
            System.out.println("Connection Header: " + keepAliveHeader);

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
