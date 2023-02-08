import java.io.*;
import java.net.*;


public class ServerSide {
    public static void main (String[] args)throws Exception {
        ServerSocket listner = new ServerSocket(1990);
        System.out.println("Server Is Ready");
        Socket socket=listner.accept();
        InputStream input = socket.getInputStream();
        DataInputStream dis = new DataInputStream(input);
        System.out.println(dis.readUTF());
        listner.close();
    }
}
