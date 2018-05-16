package ru.itpark.service;

import ru.itpark.domain.Client;
import ru.itpark.repository.ClientRepository;

import java.util.List;


public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void add(Client client) {
        clientRepository.add(client);
    }

    @Override
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> sortByYearASC() {
        return clientRepository.sortByYearASC();
    }

    @Override
    public List<Client> sortByYearDESC() {
        return clientRepository.sortByYearASC();
    }
}


