package FileSeverClient1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            String str = "";
            Socket a = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(a.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the file location: ");
            String fileName = sc.nextLine();
            FileInputStream fi = new FileInputStream(fileName);
            int n;
            while ((n = fi.read()) != -1) {
                str += Character.toString((char) n);
            }
            // System.out.println("Original Content" + str);
            // StringBuffer strb = new StringBuffer(str);
            // // System.out.println("Reverse Content" + strb.reverse());
            // StringBuffer rev = (strb.reverse());
            // String result = rev.toString();
            dout.writeUTF(str);
            dout.flush();
            a.close();
            sc.close();
            fi.close();
        } catch (Exception e) {
            System.out.println("Exception Occured: " + e);
        }
    }
}

