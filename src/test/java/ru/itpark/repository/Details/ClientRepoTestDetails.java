package ru.itpark.repository.Details;

import ru.itpark.domain.Client;
import ru.itpark.repository.BuyRepository;
import ru.itpark.repository.BuyRepositoryMySQLimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepoTestDetails {

    private final String url = "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";
    private static String text;
    private static int num;


    protected int findClientIdByPhoneNumber(String phoneNumber) {
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

    protected List<Client> findClientById(int id) {
        List<Client> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, name, year, phoneNumber, eMail FROM clients2 WHERE id=?")
            ) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    list.add(
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

        return list;
    }

    protected List<Client> expectedClient() {
        List<Client> list = new ArrayList<>();

        list.add(
                new Client(
                        3,
                        "Andy",
                        2000,
                        "89273245698",
                        "andy777@gmail.com"
                )
        );

        return list;
    }


    public void removedClient() {

    }

    protected List<Client> expectedSortClientsByYearASC() {
        List<Client> list = new ArrayList<>();

        list.add(
                new Client(
                        1,
                        "Vova",
                        1970,
                        "+7999444555666",
                        "zxcv@mail.ru"
                )
        );

        list.add(
                new Client(
                        2,
                        "Masha",
                        1988,
                        "+79503214569",
                        "aaa@mail.ru"
                )
        );

        list.add(
                new Client(
                        17,
                        "Ivan",
                        1995,
                        "+79178888888",
                        "ivan777@gmail.com"
                )
        );

        list.add(
                new Client(
                        3, "Andy",
                        2000,
                        "89273245698",
                        "andy777@gmail.com"
                )
        );

        return list;
    }


    protected List<Client> expectedSortClientsByYearDESC() {
        List<Client> list = new ArrayList<>();

        list.add(
                new Client(
                        3, "Andy",
                        2000,
                        "89273245698",
                        "andy777@gmail.com"
                )
        );

        list.add(
                new Client(
                        17,
                        "Ivan",
                        1995,
                        "+79178888888",
                        "ivan777@gmail.com"
                )
        );

        list.add(
                new Client(
                        2,
                        "Masha",
                        1988,
                        "+79503214569",
                        "aaa@mail.ru"
                )
        );

        list.add(
                new Client(
                        1,
                        "Vova",
                        1970,
                        "+7999444555666",
                        "zxcv@mail.ru"
                )
        );


        return list;
    }


    protected List<Client> expectedFindAllClients() {

        List<Client> list = new ArrayList<>();
        list.add(
                new Client(
                        1,
                        "Vova",
                        1970,
                        "+7999444555666",
                        "zxcv@mail.ru"
                )
        );

        list.add(
                new Client(
                        2,
                        "Masha",
                        1988,
                        "+79503214569",
                        "aaa@mail.ru"
                )
        );

        list.add(
                new Client(
                        3, "Andy",
                        2000,
                        "89273245698",
                        "andy777@gmail.com"
                )
        );

        list.add(
                new Client(
                        17,
                        "Ivan",
                        1995,
                        "+79178888888",
                        "ivan777@gmail.com"
                )
        );

        return list;
    }
}
