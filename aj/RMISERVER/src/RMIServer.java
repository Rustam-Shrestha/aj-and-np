import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {
    public RMIServer() throws RemoteException {
        super();
    }

    public String getMessage() throws RemoteException {
        return "Hello from Server!"; //this should show up on client
    }

    public static void main(String[] args) {
        try {
            RMIServer server = new RMIServer();
            LocateRegistry.createRegistry(1099); // Start RMI Registry
            //0.0.0.0 meeeans this will serve any IP address it finds
            Naming.rebind("rmi://0.0.0.0/RemoteServer", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
