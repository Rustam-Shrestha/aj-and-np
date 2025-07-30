import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.util.Arrays;

public class SecureSocketWithCiphers {
    public static void main(String[] args) {
        String serverAddress = "talknep.com"; // Replace with actual server
        int serverPort = 443; // Replace with actual port

        try {
            // Get SSL socket factory
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket(serverAddress, serverPort);
            
            // Define preferred cipher suites (common SSH-like ciphers)
            String[] cipherSuites = {
                "TLS_AES_128_GCM_SHA256",
                "TLS_AES_256_GCM_SHA384",
                "TLS_CHACHA20_POLY1305_SHA256"
            };

            // Enable selected cipher suites
            sslSocket.setEnabledCipherSuites(cipherSuites);

            // Print active cipher suites
            System.out.println("Enabled Cipher Suites:");
            Arrays.stream(sslSocket.getEnabledCipherSuites()).forEach(System.out::println);

            // Confirm connection status
            System.out.println("Socket connected: " + sslSocket.isConnected());

            sslSocket.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}

