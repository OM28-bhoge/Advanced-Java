import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class firstcon {
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/om", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customer");
        while (resultSet.next()) {
            int iid = resultSet.getInt("Cid");
            String Fame = resultSet.getString("name");
            System.out.println(iid + " . " + Fame);
        }
    }

}