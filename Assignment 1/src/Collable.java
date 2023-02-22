import java.sql.*;
import java.util.Scanner;

public class Collable {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/Students";
        String USERNAME = "root";
        String PASSWORD = "root";

        int rollno;
        String fname,lname,cls;
        Scanner s = new Scanner(System.in);
        System.out.println("\n Enter RollNo:");
        rollno = s.nextInt();
        System.out.println("\n Enter First Name:");
        fname = s.next();
        System.out.println("\n Enter Last Name:");
        lname = s.next();
        System.out.println("\n Enter Class:");
        cls = s.next();

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            String s1 = "{CALL student_in(?,?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(s1);

            cstmt.setInt(1,rollno);
            cstmt.setString(2,fname);
            cstmt.setString(3,lname);
            cstmt.setString(4,cls);
            System.out.printf("\n Value Inserted Successfully");
            ResultSet resultSet = cstmt.executeQuery();
            while (resultSet.next())
            {
                int Rollno = resultSet.getInt(1);
                String Fname = resultSet.getString(2);
                String Lname = resultSet.getString(3);
                String Class = resultSet.getString(4);

                System.out.printf("\n RollNo: %d \n First Name: %s \n Last Name: %s \n Class: %s",Rollno,Fname,Lname,Class);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}