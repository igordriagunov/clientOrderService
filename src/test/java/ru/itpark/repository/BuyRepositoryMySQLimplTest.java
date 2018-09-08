package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.Buy;

import static org.junit.jupiter.api.Assertions.*;

class BuyRepositoryMySQLimplTest {

    private BuyRepository buyRepository = new BuyRepositoryMySQLimpl();

    @Test
    @DisplayName("Add new buy in database")
    void add() {

        Buy buy1 = new Buy(
                4,
                5,
                14000
        );

        buyRepository.add(buy1);

        assertEquals(4, buy1.getId());

    }

    @Test
    void findTotalByClientId() {
    }

    @Test
    void clientStatus() {
    }

    @Test
    void sortClientByTotal() {
    }
}