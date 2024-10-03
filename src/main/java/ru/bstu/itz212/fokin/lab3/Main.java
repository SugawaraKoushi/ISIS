package ru.bstu.itz212.fokin.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Publication> publications = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Publication p = new Book();

        p.init(scanner);
    }
}
