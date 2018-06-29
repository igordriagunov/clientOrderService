package ru.itpark.service;

import ru.itpark.domain.Client;
import ru.itpark.repository.ClientRepoJPAImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientServ {

    private final ClientRepoJPAImpl clientRepoJPAImpl;

    public ClientServ(ClientRepoJPAImpl clientRepoJPAImpl) {
        this.clientRepoJPAImpl = clientRepoJPAImpl;
    }

    public void add(Client client) {
        clientRepoJPAImpl.saveAndFlush(client);

    }
}
