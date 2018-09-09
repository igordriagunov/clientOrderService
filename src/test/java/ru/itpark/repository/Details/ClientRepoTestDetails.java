package ru.itpark.repository.Details;

import ru.itpark.repository.BuyRepository;
import ru.itpark.repository.BuyRepositoryMySQLimpl;

import java.sql.*;

public class ClientRepoTestDetails {

    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    private static String text;
    private static int num;


    public int findClientIdByPhoneNumber(String phoneNumber) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT id FROM clients2 WHERE phoneNumber=?"
            )
            ) {
                statement.setString(1, phoneNumber);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    num = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
