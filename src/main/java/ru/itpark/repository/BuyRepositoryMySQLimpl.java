package ru.itpark.repository;

import ru.itpark.domain.Buy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyRepositoryMySQLimpl implements BuyRepository {

    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    private static int total = 0;

    @Override
    public void add(Buy buy) {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "INSERT INTO orders2 (id, clientId, orderDate, orderSum) VALUES (?,?,?,?);")) {

                statement.setInt(1, buy.getId());
                statement.setInt(2, buy.getClientId());
                statement.setString(3, buy.getOrderDate());
                statement.setInt(4, buy.getOrderSum());


                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Buy> findTotalByClientId(int clientId) {
        List<Buy> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "SELECT id, clientId, SUM(orderSum) AS orderSum FROM orders2 WHERE clientId=? ORDER BY orderSum;")) {
                statement.setInt(1, clientId);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
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


    @Override
    public int clientStatus(int clientId) {

        List<Integer> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "SELECT id, clientId, orderSum FROM orders2 WHERE clientId=?")) {
                statement.setInt(1, clientId);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    list.add(
                            resultSet.getInt("orderSum")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int buy : list) {

            total += buy;
        }
        if (total >= 0 && total <= 30_000) {
            System.out.println("Status : Бронза");
        } else {
            if (total >= 30_000 && total <= 70_000) {
                System.out.println("Status : Серебро");
            } else {
                if (total >= 70_000 && total <= 100_000) {
                    System.out.println("Status : Золото");
                } else {
                    if (total > 100_000) {
                        System.out.println("Status : Платина");
                    }
                }
            }
        }
        return total;
    }

    @Override
    public List<Buy> sortClientByTotal() {
        List<Buy> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery(
                                "SELECT id, clientId, SUM(orderSum) AS orderSum FROM orders2 GROUP BY clientId ORDER BY orderSum DESC");

                while (resultSet.next()) {
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

    private void init() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS orders2 (\n" +
                        "id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                        "clientId integer references clients2(id),\n" +
                        "orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL  ,\n" +
                        "orderSum INTEGER NOT NULL\n" +
                        ");\n"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

