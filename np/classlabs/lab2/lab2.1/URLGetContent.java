import java.net.URL;

public class URLGetContent {
    public static void main(String[] args) {
        try {
            // Define the URL to access
            URL url = new URL("https://www.kathkhabar.com");

            // Retrieve the content from the URL
            Object content = url.getContent();

            // Print the retrieved object's class type (helps understand the type of content)
            System.out.println("Content Type: " + content.getClass().getName());
        } catch (Exception e) {
            // Handle exceptions if the URL is invalid or data cannot be retrieved
            System.out.println("Error retrieving content: " + e.getMessage());
        }
    }
}
