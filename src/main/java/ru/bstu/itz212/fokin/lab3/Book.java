package ru.bstu.itz212.fokin.lab3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Book extends Publication {
    private String name;
    private String author;
    private Date publicationDate;
    private String publisher;
    private String category;
    private int pages;

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите название книги: ");
        name = scanner.next();
        System.out.print("Введите автора книги: ");
        author = scanner.next();
        System.out.print("Введите дату публикации: ");
        Pattern pattern = Pattern.compile("\\d\\d.\\d\\d.\\d{4}");
        String dateString = scanner.next(pattern);

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            publicationDate = formatter.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Введите издательство: ");
        publisher = scanner.next();
        System.out.print("Введите категорию книги: ");
        category = scanner.next();
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
        return String.format("%s. %s. %s", name, author, publicationDate);
    }
}
