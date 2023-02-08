import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args)throws Exception {
        Socket clientSocket = new Socket("localhost",1990);
        OutputStream os = clientSocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner scan = new Scanner(System.in);
        String msg = scan.nextLine();
        dos.writeUTF(msg);
        clientSocket.close();
    }    
}
