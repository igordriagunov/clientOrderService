package ru.itpark.repository;

import ru.itpark.domain.Buy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyRepoTestDetails {

    private BuyRepository buyRepository = new BuyRepositoryMySQLimpl();
    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    private static int value = 0;
    private static int total = 0;

    public int findOrderSumByIdTest(int id) {
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

    public int findTotalByClientIdTest(int clientId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "SELECT SUM(orderSum) AS orderSum FROM orders2 WHERE clientId=? ORDER BY orderSum;")) {
                statement.setInt(1, clientId);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    total = resultSet.getInt("orderSum");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }


    public List<Integer> sortClientByTotalTest() {
        List<Integer> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery(
                                "SELECT SUM(orderSum) AS orderSum FROM orders2 GROUP BY clientId ORDER BY orderSum DESC");

                while (resultSet.next()) {
                    list.add(
                            resultSet.getInt("orderSum")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
