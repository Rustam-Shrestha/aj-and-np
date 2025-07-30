import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;

public class SecureServerSocketTest {
    public static void main(String[] args) {
        int serverPort = 443; // Replace with the actual port you want to use

        try {
            // Create SSL server socket
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(serverPort);

            System.out.println("Secure server listening on port " + serverPort);

            while (true) {
                // Accept client connection
                serverSocket.accept();
                System.out.println("Client connected!");
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
