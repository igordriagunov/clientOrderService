package ru.itpark.domain;

import java.util.Objects;

public class Client {

    private int id;
    private String name;
    private int year;
    private String phoneNumber;
    private String eMail;

    public Client(int id, String name, int year, String phoneNumber, String eMail) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                year == client.year &&
                Objects.equals(name, client.name) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(eMail, client.eMail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, year, phoneNumber, eMail);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}