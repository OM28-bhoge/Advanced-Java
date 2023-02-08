import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class TwoWayCommServer {
    public static void main(String abc[]) throws Exception {
        ServerSocket listener = new ServerSocket(1980);
        OutputStream os = clientSocket.getOutputStream();
        DataInputStream dos = new DataInputStream(os);
        InputStream is = serverSocket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        for(int i=1;i<4;i++) {
            Scanner scan = new Scanner(System.in);
            String msg = scan.nextLine();
            dos.writeUTF(msg);
            System.out.println(dis.readUTF());
        } 
        clientSocket.close();
    }
    }