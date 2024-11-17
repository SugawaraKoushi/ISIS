package ru.bstu.itz212.fokin.lab5.models;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private String ownerLastName;
    private String ownerFirstName;
    private String ownerMiddleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerMiddleName() {
        return ownerMiddleName;
    }

    public void setOwnerMiddleName(String ownerMiddleName) {
        this.ownerMiddleName = ownerMiddleName;
    }
}
