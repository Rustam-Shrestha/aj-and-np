import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class NISTReader {

    public static void main(String[] args) {
        try (Socket socket = new Socket("nist.gov", 13);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(" " + line);
            }
        } catch (Exception e) {
            System.out.println(" Failed to connect: " + e.getMessage());
        }
    }
}
