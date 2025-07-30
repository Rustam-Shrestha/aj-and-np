import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpecificHeaderFieldsExample {
    public static void main(String[] args) {
        try {
            // Specify the URL
            URL url = new URL("https://google.com");

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method (optional)
            connection.setRequestMethod("GET");

            // Connect to the URL
            connection.connect();

            // Retrieve specific headers
            String contentType = connection.getHeaderField("Content-Type");
            String contentLength = connection.getHeaderField("Content-Length");
            String contentEncoding = connection.getHeaderField("Content-Encoding");
            String server = connection.getHeaderField("Server");
            String date = connection.getHeaderField("Date");

            // Print the specific headers
            System.out.println("Content-Type: " + contentType);
            System.out.println("Content-Length: " + contentLength);
            System.out.println("Content-Encoding: " + contentEncoding);
            System.out.println("Server: " + server);
            System.out.println("Date: " + date);

            // Disconnect
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
