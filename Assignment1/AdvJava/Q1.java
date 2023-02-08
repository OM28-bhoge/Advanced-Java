import java.sql.*;
class Q1
{
    public static void main(String[] args) 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvJava", "root", "root");
            CallableStatement cs =(CallableStatement) con.prepareCall("{call studentinfo(?,?)}");
            cs.setInt(1, 4);
            cs.setString(2,"Hardya");
            cs.execute();
            ResultSet rs = cs.executeQuery("select * from student");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
    }    
}