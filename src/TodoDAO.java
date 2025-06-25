import java.sql.*;
import java.util.Scanner;

public class TodoDAO {

    public void addTodo(String title, String description) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO todos (title, description) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.executeUpdate();
            System.out.println("Todo added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listTodos() {
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM todos");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("title") +
                        " | " + rs.getString("description") + " | " + rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTodo(int id, String title, String description) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE todos SET title=?, description=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setInt(3, id);
            int updated = ps.executeUpdate();
            if (updated > 0)
                System.out.println("Todo updated!");
            else
                System.out.println("Todo not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM todos WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int deleted = ps.executeUpdate();
            if (deleted > 0)
                System.out.println("Todo deleted!");
            else
                System.out.println("Todo not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
