import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MessageServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            MessageServiceImpl messageService = new MessageServiceImpl();

            // Create the RMI registry on port 1099 (default port)
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to a name in the RMI registry
            Naming.rebind("MessageService", messageService);

            // Server is ready
            System.out.println("RMI server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
