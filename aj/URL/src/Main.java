import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        try {
            // URI demonstration
            URI uri = new URI("https://google.com");

            System.out.println("URI:");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart());
            System.out.println("Authority: " + uri.getAuthority());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
            System.out.println();

            // URL demonstration
            URL url = new URL("https://example.com:8080/path?query=java#fragment");

            System.out.println("URL:");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Ref: " + url.getRef());

        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
