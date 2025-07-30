import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost"; // Default host

        // Check if a host is provided as a command-line argument
        if (args.length > 0) {
            host = args[0];
        }

        System.out.println("Scanning ports on host: " + host);

        for (int port = 1; port <= 1024; port++) {
            if (isPortOpen(host, port)) {
                System.out.println("Port " + port + " seems to be open.");
                break; // Exit after finding the first open port
            }
        }
    }

    private static boolean isPortOpen(String host, int port) {
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 200);
            return true;
        } catch (IOException e) {
            return false; // Port is not open
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
