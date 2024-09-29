/**
 * ConsoleInput
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConsoleInput {
    private static Scanner sc;
    private static final Logger LOGGER = LogManager.getLogger();

    static {
        sc = new Scanner(System.in);
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
     * @return порядковый номер месяца
     */
    public static int month() {
        System.out.print("Введите номер месяца (от 1 до 12): ");
        return sc.nextInt();
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

        LOGGER.debug("Ввод значений массива");
        for (int i = 0; i < length; i++) {
            System.out.printf("a[%d] = ", i);
            array[i] = sc.nextInt();
        }

        return array;
    }

    public static void close() {
        sc.close();
    }
}
