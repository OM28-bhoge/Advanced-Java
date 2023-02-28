import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VowelCounterImpl extends UnicastRemoteObject implements VowelCounter {

    public VowelCounterImpl() throws RemoteException {
        super();
    }

    @Override
    public int countVowels(String str) throws RemoteException {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ("AEIOUaeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}