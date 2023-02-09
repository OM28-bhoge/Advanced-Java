import java.rmi.*;
public class MyClient {
    public static void main(String[] args)
    {
        try
        {
            Power stub = (Power)Naming.lookup("rmi://localhost:1995/");
            System.out.println(stub.Power1());
        }
        catch(Exception e)
        {}
    }
}
