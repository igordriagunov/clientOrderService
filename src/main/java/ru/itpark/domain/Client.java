package ru.itpark.domain;

public class Client {

    private int id;
    private String name;
    private int data;
    private String phoneNumber;
    private String eMail;

    public Client(int id, String name, int data, String phoneNumber, String eMail) {
        this.id = id;
        this.name = name;
        this.data = data;
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data=" + data +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}