package ru.itpark.repository;

import ru.itpark.domain.Buy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyRepository {

    private String url;
    private String user;
    private String password;
    private static int total;

    public BuyRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

//    private void orderInit() {
//
//        try (Connection connection = DriverManager.getConnection(url)) {
//            try (Statement statement =
//                         connection.createStatement()) {
//
//                statement.execute("CREATE TABLE IF NOT EXISTS buy (\n" +
//                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                        "clientId INTEGER NOT NULL ,\n" +
//                        "orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL  ,\n" +
//                        "orderSum INTEGER NOT NULL ,\n" +
//                        "FOREIGN KEY (clientId) REFERENCES clients(id)\n" +
//                        ");");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public void add(Buy buy) {

        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "INSERT INTO orders (id, clientId, orderDate, orderSum) VALUES (?,?,?,?);")) {

                statement.setInt(1, buy.getId());
                statement.setInt(2, buy.getClientId());
                statement.setString(3, buy.getOrderDate());
                statement.setInt(4, buy.getOrderSum());


                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Buy> findTotalByClientId(int clientId) {
        List<Buy> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "SELECT id, clientId, SUM(orderSum) AS orderSum FROM orders WHERE clientId=? ORDER BY orderSum;")) {
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

//        BuyRepository.total = 0;
//
//        for (int buy : list) {
//
//            total += buy;
//        }
        return list;

    }


    public int clientStatus(int clientId) {

        List<Integer> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "SELECT id, clientId, orderSum FROM orders WHERE clientId=?")) {
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
        BuyRepository.total = 0;

        for (int buy : list) {

            total += buy;
        }
        if (total >= 0 && total <= 10_000) {
            System.out.println("Status : Бронза");
        } else {
            if (total >= 10_000 && total <= 30_000) {
                System.out.println("Status : Серебро");
            } else {
                if (total >= 30_000 && total <= 70_000) {
                    System.out.println("Status : Золото");
                } else {
                    if (total >= 70_000 && total <= 100_000) {
                        System.out.println("Status : Платина");
                    }
                }
            }
        }
        return total;
    }

    public List<Buy> sortClientByTotal() {
        List<Buy> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery(
                                "SELECT id, clientId, SUM(orderSum) AS orderSum FROM orders GROUP BY clientId ORDER BY orderSum DESC");

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
}

