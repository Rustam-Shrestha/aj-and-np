import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureClientTest {
    public static void main(String[] args) {
        String serverAddress = "google.com"; // Replace with actual server
        int serverPort = 443; // Replace with actual port

        try {
            // Create SSL socket
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket(serverAddress, serverPort);
            
            System.out.println("Socket connected: " + sslSocket.isConnected());

            sslSocket.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
