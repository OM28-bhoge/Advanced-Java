import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);
            // To make client application to we need to create instance of Socket
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            // Allows to give i/p
            // getOutputStream() returns an output stream for writing bytes to this socket.
            // Trying to give i/p by user using Scanner
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the i/p that u want to send to the server");
            String msg = sc.nextLine();
            dout.writeUTF(msg);
            // sending the data to the server in unicode string
            dout.flush();
            //
            dout.close();
            // connection close with DataOutputStream
            s.close();
            // Socket connection closed
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
