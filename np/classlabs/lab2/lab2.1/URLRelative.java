import java.net.URL;

public class URLRelative {
    public static void main(String[] args) {
        try {
            URL baseURL = new URL("https://www.kathkhabar.com/folder/");
            URL relativeURL = new URL(baseURL, "page.html");
            System.out.println("Relative URL: " + relativeURL);
        } catch (Exception e) {
            System.out.println("Invalid URL");
        }
    }
}
