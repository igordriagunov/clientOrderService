package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.repository.Details.ClientRepoTestDetails;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryMySQLimplTest extends ClientRepoTestDetails {

    private ClientRepository clientRepository = new ClientRepositoryMySQLimpl();

    @Test
    @DisplayName("check find client id by phone number, client should be exists")
    void add() {

        assertEquals(1, findClientIdByPhoneNumber("+7999444555666"));
        assertEquals(expectedClient(), findClientById(3));
    }

    @Test
    @DisplayName("check find all clients")
    void findAll() {

        assertEquals(expectedFindAllClients(), findAllClients());
    }

    @Test
    @DisplayName("check remove client by id")
    void removeByClientId() {

        // check client exists
        //TODO: check removed client

        assertEquals(2, findClientIdByPhoneNumber("+79503214569"));
//        assertEquals(removedClient(), clientRepository.removeByClientId(2));
    }


    @Test
    void sortByYearASC() {

        assertEquals(expectedSortClientsByYearASC(), clientRepository.sortByYearASC());
    }

    @Test
    void sortByYearDESC() {

        assertEquals(expectedSortClientsByYearDESC(), clientRepository.sortByYearDESC());
    }
}