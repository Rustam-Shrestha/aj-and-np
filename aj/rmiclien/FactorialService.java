// FactorialService.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FactorialService extends Remote {
    long computeFactorial(int num) throws RemoteException;
}
