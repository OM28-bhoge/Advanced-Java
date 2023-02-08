import java.sql.*;

class Main
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Q6" ,"root","root");
			
			Statement smt = con.createStatement();
			String sql = "CREATE TABLE student(rno int primary key,sname varchar(5),email varchar(15),addr varchar(10),cid int references course(cid))";
			String sql1 = "CREATE TABLE course(cid int primary key,cname varchar(15),fee double)";
			String sql2 = "CREATE TABLE result(rno int references student(rno),percentage double)";
			String sql3 = "INSERT INTO student('101','ABC','abc@gmail.com','Pune','1001')";
			String sql4 = "INSERT INTO course values('1001','Java','15000')";
			String sql5 = "INSERT INTO result values('101','89.5')";
			String sql6 = "DELETE FROM student";
			
			smt.execute(sql);
			smt.execute(sql1);
			smt.execute(sql2);
			smt.execute(sql3);
			smt.execute(sql4);
			smt.execute(sql5);
			smt.execute(sql6);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
}
