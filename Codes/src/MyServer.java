import java.rmi.*;
import java.rmi.registry.*;
public class MyServer {
    public static void main(String[] args)
    {
        try
        {
            Power stub = new PowerRemote();
            Naming.rebind ("rmi://localhost:1995/");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } 
}
