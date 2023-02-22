// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class Q6 extends Frame implements ActionListener {

//     Label lblRoll, lblName, lblEmail, lblAddress, lblCourseID, lblResult, lblPercentage;
//     TextField tfRoll, tfName, tfEmail, tfAddress, tfCourseID, tfPercentage;
//     Button btnNew, btnSave, btnEdit, btnDelete;

//     Connection con;
//     Statement stmt;

//     Q6() {
//         setLayout(new FlowLayout());
//         lblRoll = new Label("Roll");
//         lblName = new Label("Name");
//         lblEmail = new Label("Email");
//         lblAddress = new Label("Address");
//         lblCourseID = new Label("Course ID");
//         lblResult = new Label("Result");
//         lblPercentage = new Label("Percentage");
//         tfRoll = new TextField(20);
//         tfName = new TextField(20);
//         tfEmail = new TextField(20);
//         tfAddress = new TextField(20);
//         tfCourseID = new TextField(20);
//         tfPercentage = new TextField(20);
//         btnNew = new Button("New");
//         btnSave = new Button("Save");
//         btnEdit = new Button("Edit");
//         btnDelete = new Button("Delete");

//         add(lblRoll);
//         add(tfRoll);
//         add(lblName);
//         add(tfName);
//         add(lblEmail);
//         add(tfEmail);
//         add(lblAddress);
//         add(tfAddress);
//         add(lblCourseID);
//         add(tfCourseID);
//         add(lblResult);
//         add(lblPercentage);
//         add(tfPercentage);
//         add(btnNew);
//         add(btnSave);
//         add(btnEdit);
//         add(btnDelete);

//         btnNew.addActionListener(this);
//         btnSave.addActionListener(this);
//         btnEdit.addActionListener(this);
//         btnDelete.addActionListener(this);

//         setTitle("JDBC AWT Application");
//         setSize(400, 300);
//         setVisible(true);
//         connectToDB();
//     }

//     public void actionPerformed(ActionEvent ae) {
//         String str = ae.getActionCommand();

//         if (str.equals("New")) {
//             clearFields();
//         }

//         else if (str.equals("Save")) {
//             try {

//                 int roll = Integer.parseInt(tfRoll.getText());
//                 String name = tfName.getText();
//                 String email = tfEmail.getText();
//                 String address = tfAddress.getText();

//                 String query = "INSERT INTO table_name(id, name, email, address) VALUES(" + id + ", '" + name + "', '"
//                         + email + "', '" + address + "')";
//                 stmt.executeUpdate(query);
//             } catch (Exception e) {
//                 System.out.println(e);
//             }
//         } else if (str.equals("Edit")) {
//             try {
//                 int id = Integer.parseInt(tfId.getText());
//                 String name = tfName.getText();
//                 String email = tfEmail.getText();
//                 String address = tfAddress.getText();

//                 String query = "UPDATE table_name SET name='" + name + "', email='" + email + "', address='" + address
//                         + "' WHERE id=" + id;
//                 stmt.executeUpdate(query);
//             } catch (Exception e) {
//                 System.out.println(e);
//             }
//         }

//         else if (str.equals("Delete")) {
//             try {

//                 int id = Integer.parseInt(tfId.getText());

//                 String query = "DELETE FROM table_name WHERE id=" + id;
//                 stmt.executeUpdate(query);
//             } catch (Exception e) {
//                 System.out.println(e);
//             }
//         }
//     }

//     private void clearFields() {
// 	}

// 	void connectToDB() {
//         try {
//             Class.forName("com.mysql.jdbc.Driver");
//             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "mysql");

//             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Students (name, rollno, marks) VALUES (?, ?, ?)");
//             pstmt.setString(1, tfName.getText());
//             Label tfRollNo;
// 			pstmt.setInt(2, Integer.parseInt(tfRollNo.getText()));
//             Label tfMarks;
// 			pstmt.setInt(3, Integer.parseInt(tfMarks.getText()));

//             int result = pstmt.executeUpdate();
//             if (result == 1) {
//                 tfName.setText("");
//                 tfRollNo.setText("");
//                 tfMarks.setText("");
//                 System.out.println("Data saved successfully.");
//             } else {
//                 System.out.println("Error saving data.");
//             }
//             conn.close();
//         } catch (Exception e) {
//             System.out.println("Error: " + e.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         new Q6();
//     }
// }
