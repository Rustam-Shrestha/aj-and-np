/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package downloadwrbpage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWrbPage {

    public static void main(String[] args) 
    {
       // Replace with the desired URL
        String webAddress = "http://www.example.com";
        String outputFileName = "downloaded_page.html";
        
        try {
            // Create a URL object
            URL url = new URL(webAddress);
            
            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Check for successful response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the input stream
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                
                // Write to output file
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                
                // Close resources
                writer.close();
                reader.close();
                System.out.println("Webpage downloaded successfully as " + outputFileName);
            } else {
                System.out.println("Failed to download webpage. HTTP response code: " + responseCode);
            }
            
            // Disconnect the connection
            connection.disconnect();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
