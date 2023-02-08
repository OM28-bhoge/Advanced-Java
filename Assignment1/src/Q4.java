import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Q4 extends Frame {
    Label l1,l2,l3,l4;
    TextField tf1,tf2,tf3,tf4;
    Button b1;
    TextArea textArea;
    Q4(){
        l1 = new Label("Student RollNo:");
        tf1 = new TextField(20);

        l2 = new Label("Student First Name:");

        tf2 = new TextField(20);

        l3 = new Label("Student Last Name:");

        tf3 = new TextField(20);

        l4 = new Label("Student Class");

        tf4 = new TextField(20);


        b1 = new Button("Submit");
        
        textArea = new TextArea(20,30);

        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(l3);
        add(tf3);
        add(l4);
        add(tf4);
        add(b1);
        add(textArea);

        setVisible(true);
        setSize(400,400);
        setLayout(new FlowLayout());
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InsertRecord();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }
    void InsertRecord() throws Exception{
        String DB_URL = "jdbc:mysql://localhost:3306/Students";
        String USERNAME = "root";
        String PASSWORD = "root";
        
        int RollNo = Integer.parseInt(tf1.getText());
        String FName = tf2.getText();
        String LName = tf3.getText();
        String cls = tf4.getText();

        Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        String s1 = "INSERT INTO student_info(RollNo,FName,LName,Class) VALUES (?,?,?,?);";
        PreparedStatement cstmt = conn.prepareStatement(s1);
        
        cstmt.setInt(1,RollNo);
        cstmt.setString(2,FName);
        cstmt.setString(3,LName);
        cstmt.setString(4,cls);

        cstmt.executeUpdate();

        String s2 = "SELECT * FROM student_info where RollNo = ?";


        PreparedStatement pstmt = conn.prepareStatement(s2);
        pstmt.setInt(1,RollNo);

        ResultSet resultSet = pstmt.executeQuery();
        
        while (resultSet.next()){
            RollNo = resultSet.getInt(1);
            FName = resultSet.getString(2);
            LName = resultSet.getString(3);
            cls = resultSet.getString(4);

            String str = "\n Student Details as Follows: \n Student RollNo is "+RollNo+"\n Student Name is "+FName+ LName+" \n Student class is "+cls;

            textArea.setText(str);
            
        }
        
        

    }
    public static void main(String[] args) {
        new Q4();
    }
}