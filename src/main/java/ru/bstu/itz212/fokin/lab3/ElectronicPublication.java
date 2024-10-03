package ru.bstu.itz212.fokin.lab3;

import java.util.Date;
import java.util.Scanner;

public class ElectronicPublication extends Publication {
    private String name;
    private String[] authors;
    private String publisher;
    private Date publicationDate;
    private int access;

    @Override
    public void init(Scanner scanner) {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Date getDatePublication() {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}
