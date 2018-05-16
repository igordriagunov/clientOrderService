package ru.itpark.service;

import ru.itpark.domain.Client;
import ru.itpark.repository.ClientRepository;

import java.util.List;


public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void add(Client client) {
        clientRepository.add(client);
    }

    public void update(Client client) {
        clientRepository.update(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> sortByYearASC() {
        return clientRepository.sortByYearASC();
    }

    public List<Client> sortByYearDESC() {
        return clientRepository.sortByYearASC();
    }
}


