import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface that declares the remote methods
public interface MessageService extends Remote {
    // Method to get a message from the server
    String getMessage() throws RemoteException;
}
