package ru.itpark.service;

import ru.itpark.domain.Buy;
import ru.itpark.domain.Client;

import java.util.List;

public interface ClientService {
    void add(Client client);

    void removeByClientId(int clientId);

    void update(Client client);

    List<Client> findAllClients();

    List<Client> sortByYearASC();

    List<Client> sortByYearDESC();

    void add(Buy buy);

    List<Buy> findTotalByClientId(int clientId);

    int clientStatus(int clientId);

    List<Buy> sortClientByTotal();
}
