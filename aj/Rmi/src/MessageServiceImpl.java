import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the remote interface
public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {

    // Constructor that throws RemoteException
    protected MessageServiceImpl() throws RemoteException {
        super();
    }

    // Implementation of the remote method
    @Override
    public String getMessage() throws RemoteException {
        // Return a message from the server
        return "Hello from the RMI server!";
    }
}
