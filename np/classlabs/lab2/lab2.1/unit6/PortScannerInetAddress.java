import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class PortScannerInetAddress {
    public static void main(String[] args) {
        String host = "localhost"; // Default host

        // Check if a host is provided as a command-line argument
        if (args.length > 0) {
            host = args[0];
        }

        System.out.println("Scanning ports on host: " + host);

        try {
            InetAddress inetAddress = InetAddress.getByName(host);

            for (int port = 1; port <= 1024; port++) {
                if (isPortOpen(inetAddress, port)) {
                    System.out.println("Port " + port + " seems to be open.");
                    break; // Exit after finding the first open port
                }
            }
        } catch (IOException e) {
            System.out.println("Error resolving host: " + e.getMessage());
        }
    }

    private static boolean isPortOpen(InetAddress inetAddress, int port) {
        try (Socket socket = new Socket(inetAddress, port)) {
            return true; // Successfully connected to the port
        } catch (IOException e) {
            return false; // Port is not open
        }
    }
}
