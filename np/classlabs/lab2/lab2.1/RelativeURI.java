import java.net.URI;

public class RelativeURI {
    public static void main(String[] args) {
        try {
            // Define the base URI
            URI baseURI = new URI("https://www.kathkhabar.com/folder/");

            // Define a relative URI based on the base URI
            URI relativeURI = baseURI.resolve("page.html");

            // Print the resolved full URI
            System.out.println("Resolved URI: " + relativeURI);
        } catch (Exception e) {
            // Handle URI syntax errors
            System.out.println("Invalid URI: " + e.getMessage());
        }
    }
}
