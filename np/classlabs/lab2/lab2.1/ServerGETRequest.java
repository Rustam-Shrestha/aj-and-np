import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerGETRequest {
    public static void main(String[] args) {
        try {
            // Define the target server URL with query parameters
            URL url = new URL("https://www.kathkhabar.com/search?query=java");

            // Open a connection to the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // Use GET method

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print the response content
            }
            reader.close();
        } catch (Exception e) {
            // Handle request errors
            System.out.println("Error in GET request: " + e.getMessage());
        }
    }
}
