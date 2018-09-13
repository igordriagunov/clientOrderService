package ru.itpark.repository;

import ru.itpark.domain.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryMySQLimpl implements ClientRepository {

    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";


//    public void clientInit() {
//
//        try (Connection connection = DriverManager.getConnection(url,user,password)) {
//            try (Statement statement =
//                         connection.createStatement()) {
//
//                statement.execute("CREATE TABLE IF NOT EXISTS clients (\n" +
//                        "id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
//                        "name TEXT NOT NULL ,\n" +
//                        "year INTEGER NOT NULL ,\n" +
//                        "phoneNumber TEXT NOT NULL ,\n" +
//                        "eMail TEXT NOT NULL\n" +
//                        ");");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void add(Client client) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO clients2(name, year, phoneNumber, email) VALUES (?,?,?,?);")
            ) {

                statement.setString(1, client.getName());
                statement.setInt(2, client.getYear());
                statement.setString(3, client.getPhoneNumber());
                statement.setString(4, client.geteMail());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void removeByClientId(int clientId) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM clients2 WHERE id = ?;")
            ) {
                statement.setInt(1, clientId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE clients2 SET name=?, year=?, phoneNumber=?, eMail=? WHERE id=?;")
            ) {

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

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT id, name, year, phoneNumber, eMail FROM clients2");

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


    @Override
    public List<Client> sortByYearASC() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery("SELECT id,name,year,phoneNumber,eMail FROM clients2 ORDER BY year ASC ");

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


    @Override
    public List<Client> sortByYearDESC() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet =
                        statement.executeQuery("SELECT id,name,year,phoneNumber,eMail FROM clients2 ORDER BY year DESC ");

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


    private void init() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS clients2 (\n" +
                        "id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                        "name TEXT NOT NULL ,\n" +
                        "year INTEGER NOT NULL ,\n" +
                        "phoneNumber INTEGER NOT NULL ,\n" +
                        "email TEXT NOT NULL\n" +
                        ");"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
