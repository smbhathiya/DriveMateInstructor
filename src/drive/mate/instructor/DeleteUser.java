/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package drive.mate.instructor;

/**
 *
 * @author smbha
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {

    public static boolean deleteUserByNIC(String nicNo) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Delete user from users table
            try (PreparedStatement userStatement = connection.prepareStatement("DELETE FROM users WHERE nicno = ?")) {
                userStatement.setString(1, nicNo);
                int userRowsDeleted = userStatement.executeUpdate();
                if (userRowsDeleted == 0) {
                    return false; // User with given NIC not found
                }
            }

            // Delete associated records from marks table
            try (PreparedStatement marksStatement = connection.prepareStatement("DELETE FROM marks WHERE nicno = ?")) {
                marksStatement.setString(1, nicNo);
                marksStatement.executeUpdate();
            }

            return true; // Deletion successful

        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the exception instead of printing stack trace
        }
        return false; // Deletion failed
    }
    
}

