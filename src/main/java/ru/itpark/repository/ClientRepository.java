package ru.itpark.repository;

import ru.itpark.domain.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private String url;

    public ClientRepository(String url) {
        this.url = url;
        clientInit();
        orderInit();
    }

    public void clientInit() {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement =
                         connection.createStatement()) {

                statement.execute("CREATE TABLE IF NOT EXISTS clients (\n" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
                        "name TEXT NOT NULL ,\n" +
                        "year INTEGER NOT NULL ,\n" +
                        "phoneNumber TEXT NOT NULL ,\n" +
                        "eMail TEXT NOT NULL\n" +
                        ");");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client add(Client client) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO clients(id, name, year, phoneNumber, eMail) VALUES (?,?,?,?,?);")) {

                statement.setInt(1, client.getId());
                statement.setString(2, client.getName());
                statement.setInt(3, client.getYear());
                statement.setString(4, client.getPhoneNumber());
                statement.setString(5, client.geteMail());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public void update(Client client) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE clients SET name=?, year=?, phoneNumber=?, eMail=? WHERE id=?;")) {
                statement.setString(1, client.getName());
                statement.setInt(2, client.getYear());
                statement.setString(3, client.getPhoneNumber());
                statement.setString(4, client.geteMail());
                statement.setInt(5, client.getId());

                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> sortByYearASC() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery("SELECT id,name,year,phoneNumber,eMail FROM clients ORDER BY year ASC ");

                while (resultSet.next()) {

                    clients.add(
                            new Client(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("year"),
                                    resultSet.getString("phoneNumber"),
                                    resultSet.getString("eMail")

                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }


    public List<Client> sortByYearDESC() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery("SELECT id,name,year,phoneNumber,eMail FROM clients ORDER BY year DESC ");

                while (resultSet.next()) {

                    clients.add(
                            new Client(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("year"),
                                    resultSet.getString("phoneNumber"),
                                    resultSet.getString("eMail")

                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

//     TODO: Order repository


    public void orderInit() {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement =
                         connection.createStatement()) {

                statement.execute("CREATE TABLE IF NOT EXISTS orders (\n" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL  ,\n" +
                        "orderSum INTEGER NOT NULL ,\n" +
                        "status TEXT NOT NULL,\n" +
                        "total INTEGER CHECK (total >=0) DEFAULT 0\n" +
                        ");");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
