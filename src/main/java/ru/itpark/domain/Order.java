package ru.itpark.domain;

import java.util.GregorianCalendar;

public class Order {

    private final String orderDate = new java.util.Date().toString();
    private int orderSum;
    private String status;
    private int total;

    public Order(int orderSum, String status, int total) {
        this.orderSum = orderSum;
        this.status = status;
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
