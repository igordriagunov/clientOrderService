package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.repository.Details.BuyRepoTestDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyRepositoryMySQLimplTest extends BuyRepoTestDetails {

    @Test
    @DisplayName("check orderSum by id")
    void add() {

        assertEquals(900, findOrderSumByIdTest(1));

    }

    @Test
    @DisplayName("check find total by clientId")
    void findTotalByClientId() {

        assertEquals(70000, findTotalByClientIdTest(3));
    }


    @Test
    @DisplayName("check sort clients by total")
    void sortClientByTotal() {

        List<Integer>list = new ArrayList<>();
        list.add(70000);
        list.add(27000);
        list.add(20999);
        list.add(2400);

        assertEquals(list, sortClientByTotalTest());
    }
}