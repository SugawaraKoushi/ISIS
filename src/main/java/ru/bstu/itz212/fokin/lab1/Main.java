package ru.bstu.itz212.fokin.lab1;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1. Проверка на пересечение точки и окружности");
        Point p;
        Circle c;
        RelativePosition relativePosition;
        URL pointFileURL = Main.class.getResource("/Point.txt");
        URL circleFileURL = Main.class.getResource("/Circle.txt");

        // Чтение из файла
        if (pointFileURL != null && circleFileURL != null) {
            p = FileReader.readPointFromFile(pointFileURL.getFile());
            c = FileReader.readCircleFromFile(circleFileURL.getFile());
            relativePosition = new RelativePosition(p, c);
            System.out.println(relativePosition.intersection());
        }

        // Ввод из консоли
        p = ConsoleInput.point();
        c = ConsoleInput.circle();
        relativePosition = new RelativePosition(p, c);
        System.out.println(relativePosition.intersection());
        System.out.println();

        System.out.println("Задание 2. Вывод праздников введенного месяца");
        URL monthFileURL = Main.class.getResource("/Month.txt");
        Month month;

        // Чтение из файла
        if (monthFileURL != null) {
            int num = FileReader.readMonthFromFile(monthFileURL.getFile());
            month = new Month(num);
            System.out.println(month);
        }

        // Ввод из консоли
        int num = ConsoleInput.month();
        month = new Month(num);
        System.out.println(month);
        System.out.println();

        System.out.println("Задание 3. Максимальное отношение числа к сумме его цифр");
        double maxRatio = MaxNumberToSumOfItsDigits.calculateUsingForLoop();
        System.out.printf("Цикл for: %.2f%n", maxRatio);
        maxRatio = MaxNumberToSumOfItsDigits.calculateUsingWhileLoop();
        System.out.printf("Цикл while: %.2f%n", maxRatio);
        System.out.println();

        System.out.println("Задание 4. Количество смен знаков в массиве и их позиции");
        URL arrayFileURL = Main.class.getResource("/Array.txt");

        // Чтение из файла
        if (arrayFileURL != null) {
            int[] numbers = FileReader.readArrayFromFile(arrayFileURL.getFile());
            List<Integer> changeSignPositions = ChangeSignOfNumberPositions.get(numbers);
            System.out.printf("Введенный массив: %s%n", Arrays.toString(numbers));
            System.out.printf("Количество смен знака: %d%n", changeSignPositions.size());
            System.out.printf("Смены позиций: %s%n", changeSignPositions.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }

        // Ввод из консоли
        int[] numbers = ConsoleInput.array();
        List<Integer> changeSignPositions = ChangeSignOfNumberPositions.get(numbers);
        System.out.printf("Введенный массив: %s%n", Arrays.toString(numbers));
        System.out.printf("Количество смен знака: %d%n", changeSignPositions.size());
        System.out.printf("Смены позиций: %s%n", changeSignPositions.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println();

        ConsoleInput.close();
    }
}