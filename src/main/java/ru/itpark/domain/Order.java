package ru.itpark.domain;

import java.util.GregorianCalendar;

public class Order {

    private String orderDate;
    private int orderSum;
    private String status;
    public static int total;

    public Order(String orderDate, int orderSum, String status) {
        this.orderDate = orderDate;
        this.orderSum = orderSum;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Order.total = total;
    }
}
