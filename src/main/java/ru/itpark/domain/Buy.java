package ru.itpark.domain;

import java.util.Date;
import java.util.Objects;

public class Buy {

    private int id;
    private int clientId;
    private String orderDate = new java.util.Date().toString();
    private int orderSum;


    public Buy(int id, int clientId, int orderSum) {
        this.id = id;
        this.clientId = clientId;
        this.orderSum = orderSum;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buy buy = (Buy) o;
        return id == buy.id &&
                clientId == buy.clientId &&
                orderSum == buy.orderSum &&
                Objects.equals(orderDate, buy.orderDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, clientId, orderDate, orderSum);
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", orderDate='" + orderDate + '\'' +
                ", orderSum=" + orderSum +
                '}';
    }
}
