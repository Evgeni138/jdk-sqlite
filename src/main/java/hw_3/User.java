package hw_3;

import java.sql.*;

public class User<T, K, M> implements Methods<T, K , M> {


    @Override
    public void addData(T id, K name, M tel) {
        Connection c = null;
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            String sql = "INSERT INTO users (ID, name, tel) VALUES (?, ?, ?)";
            stmt2 = c.prepareStatement(sql);
            stmt2.setObject(1, id);
            stmt2.setObject(2, name);
            stmt2.setObject(3, tel);

            stmt2.executeUpdate();
            System.out.println("User added successfully");
            stmt2.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
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

            stmt2 = c.prepareStatement("DELETE FROM users WHERE ID = ?");
            stmt2.setInt(1, (Integer) iD);
            stmt2.executeUpdate();

            stmt2.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("User deleted successfully");
    }

    @Override
    public void getData(T iD) {
        Connection c = null;
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt2 = c.prepareStatement("SELECT * FROM users WHERE ID = ?");
            stmt2.setInt(1, (Integer) iD);
            rs = stmt2.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String tel = rs.getString("tel");

                System.out.println("ID: " + id + ", Name: " + name + ", tel: " + tel);
            }
            stmt2.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("User got successfully");
    }

    public void getAll() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String tel = rs.getString("tel");

                System.out.println("ID: " + id + ", Name: " + name + ", tel: " + tel);
            }

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Users got successfully");
        System.out.println();
    }
}


