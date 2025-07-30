import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1"; // Server's IP address
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server");

            // Input and output streams for communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Create threads for reading and writing
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Error in reading from server: " + e.getMessage());
                }
            });
            /*
            start with defining the serer path and port
            then try socket connection with that host in specific port 
            define input and output stream for communication input being reader output being wrier
            thread for reading the message sent from server where socket iwill be middleware to bring the message and reader buffer holds it thread will print it
            another thread for sending message from console to server
            starting both threads and join so the sending and recieving happens concurrently no half duplex communication
             */

            Thread writeThread = new Thread(() -> {
                try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
                    String message;
                    while ((message = consoleReader.readLine()) != null) {
                        writer.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Error in writing to server: " + e.getMessage());
                }
            });

            readThread.start();
            writeThread.start();

            readThread.join(); // Wait for threads to finish
            writeThread.join();
        } catch (IOException | InterruptedException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
