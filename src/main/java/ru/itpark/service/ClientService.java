package ru.itpark.service;

import ru.itpark.domain.Client;
import ru.itpark.repository.ClientRepository;

import java.util.List;


public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client add(Client client) {
        return clientRepository.add(client);
    }

    public List<Client> sortByYearASC() {
        return clientRepository.sortByYearASC();
    }




}

