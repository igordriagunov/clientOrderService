package ru.itpark.service;

import ru.itpark.domain.Client;

import java.util.List;

public interface ClientService {
    void add(Client client);

    void update(Client client);

    List<Client> findAll();

    List<Client> sortByYearASC();

    List<Client> sortByYearDESC();
}
