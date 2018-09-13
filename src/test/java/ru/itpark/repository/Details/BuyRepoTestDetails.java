package ru.itpark.repository.Details;

import ru.itpark.domain.Buy;
import ru.itpark.repository.BuyRepository;
import ru.itpark.repository.BuyRepositoryMySQLimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyRepoTestDetails {

    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    private static int value = 0;
    private static int total = 0;

    protected List<Buy> expectedOrder() {
        List<Buy> list = new ArrayList<>();

        list.add(
                new Buy(12,
                        3,
                        14000
                )
        );

        return list;
    }

    protected List<Buy> expectedSortClientByTotal() {
        List<Buy> list = new ArrayList<>();
        list.add(
                new Buy(10,
                        3,
                        70000)
        );

        list.add(
                new Buy(
                        15,
                        17,
                        36999
                )
        );

        list.add(
                new Buy(
                        5,
                        2,
                        20999
                )
        );

        list.add(
                new
                        Buy(
                        1,
                        1,
                        2400
                )
        );

        return list;
    }

    protected List<Buy> expectedTotalByClientId() {
        List<Buy> list = new ArrayList<>();

        list.add(
                new Buy(
                        10,
                        3,
                        70000
                )
        );

        return list;
    }

    protected List<Buy> findOrderByIdTest(int id) {
        List<Buy> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, clientId, orderSum FROM orders2 WHERE id=?")) {

                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    list.add(
                            new Buy(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("clientId"),
                                    resultSet.getInt("orderSum")
                            )
                    );

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected int findTotalByClientIdTest(int clientId) {
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


    protected List<Integer> sortClientByTotalTest() {
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
