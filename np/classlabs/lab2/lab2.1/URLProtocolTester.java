import java.net.URL;

public class URLProtocolTester {
    public static void main(String[] args) {
        String urlString = "https://www.kathkhabar.com";
        try {
            URL url = new URL(urlString);
            System.out.println("Protocol: " + url.getProtocol());
        } catch (Exception e) {
            System.out.println("Invalid URL");
        }
    }
}
