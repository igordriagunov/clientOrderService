package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.repository.Details.BuyRepoTestDetails;

import static org.junit.jupiter.api.Assertions.*;

class BuyRepositoryMySQLimplTest extends BuyRepoTestDetails {

    private BuyRepository buyRepository = new BuyRepositoryMySQLimpl();

    @Test
    @DisplayName("check find order by id, order should be exists")
    void add() {

        assertEquals(expectedOrder(), findOrderByIdTest(12));
    }

    @Test
    @DisplayName("check find total by clientId")
    void findTotalByClientId() {

        assertEquals(70000, findTotalByClientIdTest(3));
        assertEquals(expectedTotalByClientId(), buyRepository.findTotalByClientId(3));
    }


    @Test
    @DisplayName("check sort clients by total")
    void sortClientByTotal() {

        assertEquals(expectedSortClientByTotal(), buyRepository.sortClientByTotal());
    }
}