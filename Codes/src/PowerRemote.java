import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
public class PowerRemote extends UnicastRemoteObject implements Power{
    PowerRemote() throws RemoteException
    {
        super();
    }
    public int Power1(int z)
    {
        int z;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base Number :: ");
        int x = sc.nextInt();
        System.out.println("Enter the Exponent Number:: ");
        int y = sc.nextInt();
        z = y^x;
        System.out.println(z);
    }
}