package ru.bstu.itz212.fokin.lab3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book extends Publication {
    private String name;
    private String author;
    private Date publicationDate;
    private String publisher;
    private int pages;

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите название книги: ");
        name = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        author = scanner.nextLine();
        System.out.print("Введите дату публикации: ");
        String dateString = scanner.nextLine();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            publicationDate = formatter.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Введите издательство: ");
        publisher = scanner.nextLine();
        System.out.print("Введите количество страниц: ");
        pages = scanner.nextInt();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Date getDatePublication() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return String.format("Книга - %s. %s / %s, %s. - %d с.", author, name, publisher, publicationDate, pages);
    }
}
