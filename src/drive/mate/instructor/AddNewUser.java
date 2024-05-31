/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package drive.mate.instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author smbha
 */
public class AddNewUser {

    public static boolean addUser(String username, String nicNo) {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, nicno) VALUES (?, ?)")) {

            statement.setString(1, username);
            statement.setString(2, nicNo);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the exception instead of printing stack trace
        }
        return false;
    }

    public static boolean userExists(String username, String nicNo) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE name = ? OR nicno = ?")){

            statement.setString(1, username);
            statement.setString(2, nicNo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

}
