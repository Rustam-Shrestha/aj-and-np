import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Adder stub = (Adder) registry.lookup("AdderService");
            int result = stub.add(5, 7);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
