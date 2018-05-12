package ru.itpark.repository;

import ru.itpark.domain.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private String url;

    public ClientRepository(String url) {
        this.url = url;
        init();
    }

    public void init() {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement =
                         connection.createStatement()) {

                statement.execute("CREATE TABLE IF NOT EXISTS clients (\n" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
                        "name TEXT NOT NULL ,\n" +
                        "data INTEGER NOT NULL ,\n" +
                        "phoneNumber INTEGER NOT NULL ,\n" +
                        "eMail TEXT NOT NULL\n" +
                        ");");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Client client) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO clients(id, name, data, phoneNumber, eMail) VALUES (?,?,?,?,?);")) {

                statement.setInt(1, client.getId());
                statement.setString(2, client.getName());
                statement.setInt(3, client.getData());
                statement.setString(4, client.getPhoneNumber());
                statement.setString(5, client.geteMail());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Client client) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE clients SET name=?, data=?,phoneNumber=?,eMail=? WHERE id=?;")) {
                statement.setString(1, client.getName());
                statement.setInt(2, client.getData());
                statement.setString(3, client.getPhoneNumber());
                statement.setString(4, client.geteMail());
                statement.setInt(5, client.getId());

                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> sortByDataASC() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery("SELECT id,name,data,phoneNumber,eMail FROM clients ORDER BY data ASC ");

                while (resultSet.next()) {

                    clients.add(
                            new Client(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("data"),
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


    public List<Client> sortByDataDESC() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery("SELECT id,name,data,phoneNumber,eMail FROM clients ORDER BY data DESC ");

                while (resultSet.next()) {

                    clients.add(
                            new Client(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("data"),
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


}
