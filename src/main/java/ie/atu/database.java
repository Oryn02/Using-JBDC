package ie.atu;

import java.sql.*;

public class database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/exampledatabase.person";
        String username = "root";
        String password = "root";

        String selectSQL = "SELECT u.username, u.password, e.email " +
                "FROM users u " +
                "JOIN emails e ON u.id = e.user_id";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String email = resultSet.getString("email");

                System.out.println("Username: " + user + ", Password: " + pass + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
