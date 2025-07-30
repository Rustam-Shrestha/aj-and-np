public class ServerLogProcessorWithoutRegex {
    public static void main(String[] args) {
        // Example log entry
        String logEntry = "205.160.186.76 unknown - [17/Jun/2013:22:53:58 -0500] \"GET /bgs/greenbg.gif HTTP 1.0\" 200 50";
        
        // Splitting the log entry by spaces
        String[] parts = logEntry.split(" ");
        
        // Extracting components based on their positions in the split array
        String ipAddress = parts[0];  // IP address
        String identity = parts[1];  // Identity (e.g., "unknown")
        String user = parts[2];  // User (e.g., "-")
        String dateTime = parts[3] + " " + parts[4];  // Date and time (concatenating parts)
        String method = parts[5].substring(1);  // Request method (removing the leading quote)
        String resource = parts[6];  // Requested resource
        String httpVersion = parts[7].substring(0, parts[7].length() - 1);  // HTTP version (removing the trailing quote)
        String responseCode = parts[8];  // Response code
        String size = parts[9];  // Size of the response
        
        // Printing extracted components
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Identity: " + identity);
        System.out.println("User: " + user);
        System.out.println("Date and Time: " + dateTime);
        System.out.println("Method: " + method);
        System.out.println("Resource: " + resource);
        System.out.println("HTTP Version: " + httpVersion);
        System.out.println("Response Code: " + responseCode);
        System.out.println("Size: " + size);
    }
}



//java serverlogprocessorwithoutregex.java

//java serverlogprocessor.java

/*
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerLogProcessor {
    public static void main(String[] args) {
        // Example log entry
        String logEntry = "205.160.186.76 unknown - [17/Jun/2013:22:53:58 -0500] \"GET /bgs/greenbg.gif HTTP 1.0\" 200 50";
        
        // Regular expression pattern to match log entry components
        String logPattern = "^(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+\

\[(\\d+/\\w+/\\d+:\\d+:\\d+:\\d+\\s+-\\d+)]\\s+\"(\\S+)\\s+(\\S+)\\s+(\\S+)\"\\s+(\\d+)\\s+(\\d+)";
        
        // Compiling the regular expression pattern
        Pattern pattern = Pattern.compile(logPattern);
        
        // Matching the log entry against the pattern
        Matcher matcher = pattern.matcher(logEntry);
        
        if (matcher.find()) {
            // Extracting components from the matched log entry
            String ipAddress = matcher.group(1);  // IP address
            String identity = matcher.group(2);  // Identity (e.g., "unknown")
            String user = matcher.group(3);  // User (e.g., "-")
            String dateTime = matcher.group(4);  // Date and time
            String method = matcher.group(5);  // Request method (e.g., "GET")
            String resource = matcher.group(6);  // Requested resource (e.g., "/bgs/greenbg.gif")
            String httpVersion = matcher.group(7);  // HTTP version (e.g., "HTTP 1.0")
            String responseCode = matcher.group(8);  // Response code (e.g., "200")
            String size = matcher.group(9);  // Size of the response (e.g., "50")
            
            // Printing extracted components
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Identity: " + identity);
            System.out.println("User: " + user);
            System.out.println("Date and Time: " + dateTime);
            System.out.println("Method: " + method);
            System.out.println("Resource: " + resource);
            System.out.println("HTTP Version: " + httpVersion);
            System.out.println("Response Code: " + responseCode);
            System.out.println("Size: " + size);
        } else {
            System.out.println("Log entry does not match the pattern.");
        }
    }
}


*/