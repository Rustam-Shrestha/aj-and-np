// FactorialClient.java
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class FactorialClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.1.65", 1099);
            FactorialService stub = (FactorialService) registry.lookup("FactorialService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number: ");
            int num = scanner.nextInt();

            long result = stub.computeFactorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
