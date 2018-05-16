package ru.itpark.service;

import ru.itpark.domain.Buy;
import ru.itpark.domain.Client;
import ru.itpark.repository.ClientRepository;
import ru.itpark.repository.BuyRepository;

import java.util.Iterator;
import java.util.List;


public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final BuyRepository buyRepository;

    public ClientServiceImpl(ClientRepository clientRepository, BuyRepository buyRepository) {
        this.clientRepository = clientRepository;
        this.buyRepository = buyRepository;
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

    public void add(Buy buy) {
        buyRepository.add(buy);
    }

    public List<Buy> findByClientId(int clientId) {
        return buyRepository.findByClientId(clientId);
    }
}




