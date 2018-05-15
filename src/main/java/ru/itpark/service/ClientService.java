package ru.itpark.service;

import ru.itpark.domain.Client;
import ru.itpark.repository.OrderRepository;

import javax.xml.ws.ServiceMode;
import java.util.List;


public class ClientService {

    private final OrderRepository orderRepository;

    public ClientService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Client> sortByYearASC() {
        return orderRepository.sortByYearASC();
    }

    public Client add(Client client) {
        return orderRepository.add(client);
    }


}

