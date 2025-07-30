import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            // Input and output streams for communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Create threads for reading and writing
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Client: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Error in reading from client: " + e.getMessage());
                }
            });
            // almost the same code for server just server hast to be listening in specific port in specific url 

            Thread writeThread = new Thread(() -> {
                try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
                    String message;
                    while ((message = consoleReader.readLine()) != null) {
                        writer.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Error in writing to client: " + e.getMessage());
                }
            });

            readThread.start();
            writeThread.start();

            readThread.join(); // Wait for threads to finish
            writeThread.join();

            socket.close();
        } catch (IOException | InterruptedException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
