package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class BuyRepositoryMySQLimplTest {

    private BuyRepository buyRepository = new BuyRepositoryMySQLimpl();
    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    public static int value = 0;

    public int findOrderSumById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT orderSum FROM orders2 WHERE id=?")) {

                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    value = resultSet.getInt("orderSum");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Test
    @DisplayName("check order by orderSum")
    void add() {

        assertEquals(-999, findOrderSumById(8));

    }

    @Test
    void findTotalByClientId() {
    }

    @Test
    void clientStatus() {
    }

    @Test
    void sortClientByTotal() {
    }
}