import java.sql.*;
public class Collable1
{
    public static void main(String[] args) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvJava", "root", "root");
            CallableStatement cs = con.prepareCall("{call studentinfo(?,?)}");
            cs.setInt(1, 10);
            cs.setString(2,"BhauKadam");
            cs.execute();
            ResultSet rs = cs.executeQuery("select * from student");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getInt(2));

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
    }    
}