package ru.itpark.repository;

import ru.itpark.domain.Client;

import java.util.List;

public interface ClientRepository {
    void add(Client client);

    void update(Client client);

    void removeByClientId(int clientId);

    List<Client> findAll();

    List<Client> sortByYearASC();

    List<Client> sortByYearDESC();
}
