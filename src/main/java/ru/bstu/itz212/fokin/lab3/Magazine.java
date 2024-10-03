package ru.bstu.itz212.fokin.lab3;

import java.util.Date;
import java.util.Scanner;

public class Magazine extends Publication {
    private String name;
    private Date publicationDate;
    private Date foundationDate;
    private String frequency;
    private String type;

    @Override
    public void init(Scanner scanner) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getDatePublication() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "";
    }
}
