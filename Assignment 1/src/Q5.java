import java.sql.*;

interface LibraryOperations {
    public void addBook(String title, String author, String ISBN);
    public void updateBook(String ISBN, String title);
    public void deleteBook(String ISBN);
    public void showBooks();
}

class Library implements LibraryOperations {
    Connection conn = null;
    Statement stmt = null;

    public Library() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "root");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(String title, String author, String ISBN) {
        try {
            String sql = "INSERT INTO books (title, author, ISBN) VALUES ('" + title + "', '" + author + "', '" + ISBN + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(String ISBN, String title) {
        try {
            String sql = "UPDATE books SET title = '" + title + "' WHERE ISBN = '" + ISBN + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String ISBN) {
        try {
            String sql = "DELETE FROM books WHERE ISBN = '" + ISBN + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showBooks() {
        try {
            String sql = "SELECT * FROM books";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String ISBN = rs.getString("ISBN");
                System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + ISBN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        lib.addBook("Moby-Dick", "Herman Melville", "978031600000");
        lib.showBooks();
        lib.updateBook("9780743273565", "The Great Gatsby - Updated");
        lib.deleteBook("978031600000");
        lib.showBooks();
    }
}
