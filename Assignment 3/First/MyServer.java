import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class MyServer {

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        VowelCounterImpl vc = new VowelCounterImpl();
        registry.rebind("VowelCounter", vc);
        System.out.println("Server ready");
    }

}
