import java.io.*;
import java.net.*;

public class MyServer{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            // Server Socket contains port no as parameter

            Socket s = ss.accept();
            // establishes connection with client
            // accept() method waits for the client.
            // client connects with the given port number, it returns an instance of Socket.

            DataInputStream dis = new DataInputStream(s.getInputStream());
            // Trying fetching the data from client and store in dis object

            String str = (String) dis.readUTF();
            // It can return unicode string,so it is necessary typecast into string for
            // better understanding of
            // content send by client

            System.out.println("message= " + str);
            // Just displaying the string send by the user

            ss.close();
            // connection close
        } catch (Exception e) {
            // If there is any error and syntactical error this suit(block of code) will
            // execute
            System.out.println(e);
        }
    }
}

