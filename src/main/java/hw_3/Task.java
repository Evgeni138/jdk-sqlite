package hw_3;

import java.sql.*;

public class Task<T, K, M> implements Methods<T, K, M> {
    @Override
    public void addData(T id, K name, M userId) {
        Connection c = null;
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            String sql = "INSERT INTO tasks (ID, name, userId) VALUES (?, ?, ?)";
            stmt2 = c.prepareStatement(sql);
            stmt2.setObject(1, id);
            stmt2.setObject(2, name);
            stmt2.setObject(3, userId);

            stmt2.executeUpdate();
            System.out.println("Task added successfully");
            stmt2.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void deleteData(T iD) {
        Connection c = null;
        PreparedStatement stmt2 = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt2 = c.prepareStatement("DELETE FROM tasks WHERE ID = ?");
            stmt2.setInt(1, (Integer) iD);
            stmt2.executeUpdate();

            stmt2.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Task deleted successfully");
    }

    @Override
    public void getData(T taskId) {
        Connection c = null;
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt2 = c.prepareStatement("SELECT * FROM tasks WHERE ID = ?");
            stmt2.setInt(1, (Integer) taskId);
            rs = stmt2.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                int userId = rs.getInt("userId");

                System.out.println("ID: " + id + ", Name: " + name + ", userId: " + userId);
            }
            stmt2.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Task got successfully");
    }
}

