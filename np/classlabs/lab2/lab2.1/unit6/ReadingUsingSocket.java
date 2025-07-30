import java.io.*;
import java.net.*;

public class ReadingUsingSocket {
    public static void main(String[] args) {
        String hostname = "www.kathkhabar.com";  // Corrected assignment
        int port = 13;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            StringBuilder time = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {  // Read until end of stream
                time.append((char) c);  // Append character to StringBuilder
            }

            System.out.println("Time from server: " + time.toString());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// java program to init socet print writer outut streamout the get http 11 host examplecom connection close and print ln empty inpput stream in where socet getimpht stream bufeer reader with input stream reader and server message is printed using while loop until readline is not null print the data and sclose socet