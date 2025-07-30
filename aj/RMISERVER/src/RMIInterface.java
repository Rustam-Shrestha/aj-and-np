import java.rmi.*;

public interface RMIInterface extends Remote {
    String getMessage() throws RemoteException;
}