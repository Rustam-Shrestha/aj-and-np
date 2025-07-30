// FactorialServer.java
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FactorialServer implements FactorialService {
    public long computeFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static void main(String[] args) {
        try {
            FactorialServer obj = new FactorialServer();
            FactorialService stub = (FactorialService) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("FactorialService", stub);

            System.out.println("Factorial RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
