import java.sql.*;

public class Q2 {
  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "root");

    // Statement Example
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
    while (rs.next()) {
      System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
    }

    // PreparedStatement Example
    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE E_NO=?");
    pstmt.setInt(1, 2);
    rs = pstmt.executeQuery();
    while (rs.next()) {
      System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
    }

    // CallableStatement Example
    CallableStatement cstmt = conn.prepareCall("{call getemployee(?)}");
    cstmt.setInt(1, 2);
    rs = cstmt.executeQuery();
    while (rs.next()) {
      System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
    }

    conn.close();
  }
} 
    
