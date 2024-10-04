package ru.bstu.itz212.fokin.lab3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Magazine extends Publication {
    private String name;
    private String publisher;
    private String type;
    private String frequency;
    private Date foundationDate;
    private Date publicationDate;

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите название журнала: ");
        name = scanner.nextLine();
        System.out.print("Введите тематику журнала: ");
        type = scanner.nextLine();
        System.out.print("""
                Выберите частоту публикации выпусков журнала:
                1. Ежемесячно
                2. Еженедельно
                """);
        frequency = switch (scanner.nextInt()) {
            case 1 -> "Ежемесячно";
            case 2 -> "Еженедельно";
            default -> "Ежемесячно";
        };

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            System.out.print("Введите дату основания журнала: ");
            String foundationDateString = scanner.nextLine();
            foundationDate = formatter.parse(foundationDateString);
            System.out.print("Введите дату публикации: ");
            String publicationDateString = scanner.nextLine();
            publicationDate = formatter.parse(publicationDateString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Введите издательство: ");
        publisher = scanner.nextLine();
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
        return String.format("Журнал - %s. %s / %s, %s", type, name, publisher, publicationDate);
    }
}
