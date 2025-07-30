import java.net.*;
import java.io.*;

public class ProxyConnection {
    public static void main(String[] args) {
        try {
            // Define proxy with IP and port
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("123.45.67.89", 8080));

            // Target URL
            URL url = new URL("https://www.katkhabar.com");

            // Open connection with proxy
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

            // Set timeouts to avoid indefinite waiting
            connection.setConnectTimeout(5000); // milliseconds
            connection.setReadTimeout(5000);

            connection.setRequestMethod("GET");

            // Trigger the connection
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Optional: Read the response if needed
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            System.out.println("Response Content: " + responseContent.toString());

        } catch (SocketTimeoutException e) {
            System.out.println("Connection timed out: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
    }
}
