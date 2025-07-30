import java.rmi.Naming;

public class MessageClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object by name in the RMI registry
            MessageService messageService = (MessageService) Naming.lookup("rmi://localhost/MessageService");

            // Invoke the remote method and print the result
            String message = messageService.getMessage();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
