import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class PasswordProtectedPageDownloader {
    public static void main(String[] args) {
        try {
            // Define the URL of the password-protected page
            URL url = new URL("http://192.168.1.254");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Add Basic Authentication Header (username:password -> Base64 encoding)
            String username = "userAdmin";
            String password = "L4Bi6ZEP8a";
            String auth = username + ":" + password;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print webpage content
            }
            reader.close();
        } catch (Exception e) {
            // Handle connection errors
            System.out.println("Error accessing protected page: " + e.getMessage());
        }
    }
}
