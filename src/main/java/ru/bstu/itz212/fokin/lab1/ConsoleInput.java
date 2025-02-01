/**
 * ConsoleInput
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConsoleInput {
    private static Scanner sc;
    private static final Logger LOGGER;

    static {
        sc = new Scanner(System.in);
        LOGGER = LogManager.getLogger(ConsoleInput.class);
    }

    /**
     * Создание точки при вводе из консоли
     * @return точка
     */
    public static Point point() {
        System.out.println("Ввод координат точки:");

        System.out.print("x = ");
        double x = sc.nextDouble();

        System.out.print("y = ");
        double y = sc.nextDouble();

        return new Point(x, y);
    }

    /**
     * Создание окружности при вводе из консоли
     * @return окружность
     */
    public static Circle circle() {
        System.out.println("Ввод параметров окружности:");

        System.out.print("x = ");
        double x = sc.nextDouble();

        System.out.print("y = ");
        double y = sc.nextDouble();

        System.out.print("r = ");
        double r = sc.nextDouble();

        return new Circle(x, y, r);
    }

    /**
     * Ввод порядкового номера месяца из консоли
     * @return Месяц под порядковым номером
     */
    public static Month month() {
        System.out.print("Введите номер месяца (от 1 до 12): ");
        int n = sc.nextInt();

        return new Month(n);
    }

    /**
     * Ввод длины массива и его значений из консоли
     * @return массив чисел
     */
    public static int[] array() {
        int length;

        do {
            System.out.print("Введите длину массива: ");
            length = sc.nextInt();

            if (length < 1) LOGGER.warn("Ввод нулевой или отрицательной длины массива");

        } while (length < 1);

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.printf("a[%d] = ", i);
            array[i] = sc.nextInt();
        }

        return array;
    }

    /**
     * Считывает путь файла
     * @return путь файла
     */
    public static String readFilePath() {
        System.out.print("Введите путь к файлу: ");
        return sc.nextLine();
    }

    public static void close() {
        sc.close();
    }
}
