package ru.itpark.repository;

import ru.itpark.domain.Buy;

import java.util.List;

public interface BuyRepository {
    void add(Buy buy);

    List<Buy> findTotalByClientId(int clientId);

    int clientStatus(int clientId);

    List<Buy> sortClientByTotal();
}
