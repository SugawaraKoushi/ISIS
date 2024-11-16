package ru.bstu.itz212.fokin.lab5.models;

import java.util.List;

public class CarOwner {
    private int id;
    private boolean gender;
    private String lastName;
    private String firstName;
    private String middleName;
    private List<Integer> cars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<Integer> getCars() {
        return cars;
    }

    public void setCars(List<Integer> cars) {
        this.cars = cars;
    }
}
