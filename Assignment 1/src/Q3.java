import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Q3 extends Frame implements ActionListener {
   private static final long serialVersionUID = 1L;
   private TextField tfId, tfName;
   private Button btnLoad, btnSave;
   private Connection con;

   public Q3() {
      tfId = new TextField();
      tfName = new TextField();
      btnLoad = new Button("Load");
      btnSave = new Button("Save");

      setLayout(new FlowLayout());
      add(new Label("ID:"));
      add(tfId);
      add(new Label("Name:"));
      add(tfName);
      add(btnLoad);
      add(btnSave);

      btnLoad.addActionListener(this);
      btnSave.addActionListener(this);
      
      setTitle("JDBC with AWT Example");
      setSize(400, 200);
      setVisible(true);
      
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
            System.exit(0);
         }
      });
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "root");
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == btnLoad) {
         try {
            int id = Integer.parseInt(tfId.getText());
            PreparedStatement pst = con.prepareStatement("select * from employee where E_NO = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
               tfName.setText(rs.getString(2));
            } else {
               tfName.setText("Not Found");
            }
         } catch (Exception e) {
            System.out.println(e);
         }
      } else if (ae.getSource() == btnSave) {
         try {
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            PreparedStatement pst = con.prepareStatement("insert into employee values (?, ?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            int i = pst.executeUpdate();
            if (i > 0) {
               System.out.println("Record Saved");
            }
         } catch (Exception e) {
            System.out.println(e);
         }
      }
   }

   public static void main(String[] args) {
      new Q3();
   }
}
