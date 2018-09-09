package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.repository.Details.ClientRepoTestDetails;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryMySQLimplTest extends ClientRepoTestDetails {

    @Test
    @DisplayName("check find client id by phone number")
    void add() {

        assertEquals(1, findClientIdByPhoneNumber("+7999444555666"));
    }

    @Test
    void removeByClientId() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void sortByYearASC() {
    }

    @Test
    void sortByYearDESC() {
    }
}