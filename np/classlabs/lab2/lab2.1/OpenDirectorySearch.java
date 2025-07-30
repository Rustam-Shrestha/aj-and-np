import java.net.URI;

public class OpenDirectorySearch {
    public static void main(String[] args) {
        try {
            // Define a sample URI with a query string for directory search
            URI uri = new URI("https://www.kathkhabar.com/files/?name=document.pdf");

            // Extract and print the query string
            System.out.println("Query String: " + uri.getQuery());
        } catch (Exception e) {
            // Handle URI syntax errors
            System.out.println("Invalid URI: " + e.getMessage());
        }
    }
}
