import java.net.*;
import java.io.*;

public class ContentGetter {

    public static void main(String[] args) {

        if (args.length > 0) {
            try {
                // ⚠️ URL(String) is deprecated in Java 20
                // ✅ Instead, use URI and convert it to URL
                URI uri = new URI(args[0]); 
                URL u = uri.toURL();  // Convert URI to URL

                try {
                    Object o = u.getContent();  // Fetch content from URL
                    System.out.println("I got a " + o.getClass().getName());
                } 
                catch (IOException ex) {
                    System.err.println("Error reading content: " + ex);
                }

            } 
            catch (URISyntaxException ex) { 
                System.err.println(args[0] + " is not a valid URI.");
            } 
            catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL.");
            }
        } 
        else {
            System.out.println("Usage: java ContentGetter <URL>");
        }
    }
}

/*
 * 
 * Error reading content: java.io.FileNotFoundException: https://www.cafeaulait.org/course/week9/spacemusic.u        
PS D:\Dashboard\miDirectarios\sixthSemester\networkProgramming\Labs\lab2> java ContentGetter "https://www.cafeaulait.org/course/week9/spacemusic.au"
I got a com.sun.media.sound.JavaSoundAudioClip
PS D:\Dashboard\miDirectarios\sixthSemester\networkProgramming\Labs\lab2> 
 */