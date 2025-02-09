/**
 * Car
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab5.models;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Представление автомобиля с ФИО владельца
 */
public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private String ownerLastName;
    private String ownerFirstName;
    private String ownerMiddleName;

    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("[А-Яа-яЁё]\\d{3}[А-Яа-яЁё]{2}\\d{2,3}");

    public void init(Scanner scanner) {
        System.out.print("Введите марку: ");
        brand = scanner.nextLine();
        System.out.print("Введите модель: ");
        model = scanner.nextLine();
        System.out.print("Введите цвет: ");
        color = scanner.nextLine();

        Matcher matcher;
        do {
            System.out.print("Введите автомобильный номер: ");
            licensePlate = scanner.nextLine();
            matcher = LICENSE_PLATE_PATTERN.matcher(licensePlate);
        } while (!matcher.find());

        System.out.println("Введите данные владельца");
        System.out.print("Фамилия: ");
        ownerLastName = scanner.nextLine();
        System.out.print("Имя: ");
        ownerFirstName = scanner.nextLine();
        System.out.print("Отчество: ");
        ownerMiddleName = scanner.nextLine();
    }

    @Override
    public String toString() {
        String owner = String.format("%s %s %s", ownerLastName, ownerFirstName, ownerMiddleName);
        return String.format("%-5d|%20s|%20s|%20s|%20s|%40s", id, brand, model, color, licensePlate, owner);
    }

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
