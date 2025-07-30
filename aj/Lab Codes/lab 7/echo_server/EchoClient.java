import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1"; // Server's IP address
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to Echo Server");

            // Input and output streams for communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            /* 
             * this is client socet it eill connect to server id which i assume is loopback
             * in the port 12345 then tru socet connection will be made if not connection throw io exception
             * afteer connection readeer for seeing server sentdata writer for sending data
             * reader for reading data from server
             * message to be sent to server via console readline writting message to server
             * unless ound message "exit" will be sent it will terminate connecion
             * 
             * 
            */
            String message;
            while (true) {
                System.out.print("Enter message: ");
                message = consoleReader.readLine();
                writer.println(message); // Send message to server

                String response = reader.readLine(); // Receive echo from server
                System.out.println(response);

                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Exiting...");
                    break;
                }
            }

            socket.close();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
