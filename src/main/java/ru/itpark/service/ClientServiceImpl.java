package ru.itpark.service;

import ru.itpark.domain.Buy;
import ru.itpark.domain.Client;

import ru.itpark.repository.BuyRepository;
import ru.itpark.repository.BuyRepositoryMySQLimpl;
import ru.itpark.repository.ClientRepository;
import ru.itpark.repository.ClientRepositoryMySQLimpl;

import java.util.List;


public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository = new ClientRepositoryMySQLimpl();
    private final BuyRepository buyRepository = new BuyRepositoryMySQLimpl();


    @Override
    public void add(Client client) {
        clientRepository.add(client);
    }

    @Override
    public void removeByClientId(int clientId) {
        clientRepository.removeByClientId(clientId);
    }


    @Override
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> sortByYearASC() {
        return clientRepository.sortByYearASC();
    }

    @Override
    public List<Client> sortByYearDESC() {
        return clientRepository.sortByYearDESC();
    }

    @Override
    public void add(Buy buy) {
        buyRepository.add(buy);
    }

    @Override
    public List<Buy> findTotalByClientId(int clientId) {
        return buyRepository.findTotalByClientId(clientId);
    }

    @Override
    public int clientStatus(int clientId) {
        return buyRepository.clientStatus(clientId);
    }

    @Override
    public List<Buy> sortClientByTotal() {
        return buyRepository.sortClientByTotal();
    }


}




