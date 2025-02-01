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

import java.util.InputMismatchException;
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
        double x = 0;
        double y = 0;

        LOGGER.info("Ввод координат точки:");

        try {
            LOGGER.info("x = ");
            x = sc.nextDouble();

            LOGGER.info("y = ");
            y = sc.nextDouble();

            return new Point(x, y);
        } catch (InputMismatchException e) {
            LOGGER.error("Некорректный ввод", e);
        }

        return null;
    }

    /**
     * Создание окружности при вводе из консоли
     * @return окружность
     */
    public static Circle circle() {
        double x = 0;
        double y = 0;
        double r = 0;

        LOGGER.info("Ввод параметров окружности:");

        try {
            LOGGER.info("x = ");
            x = sc.nextDouble();

            LOGGER.info("y = ");
            y = sc.nextDouble();

            LOGGER.info("r = ");
            r = sc.nextDouble();

            return new Circle(x, y, r);
        } catch (InputMismatchException e) {
            LOGGER.error("Некорректный ввод", e);
        }

        return null;
    }

    /**
     * Ввод порядкового номера месяца из консоли
     * @return Месяц под порядковым номером
     */
    public static Month month() {
        LOGGER.info("Введите номер месяца (от 1 до 12): ");
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
            LOGGER.info("Введите длину массива: ");
            length = sc.nextInt();

            if (length < 1) LOGGER.warn("Ввод нулевой или отрицательной длины массива");

        } while (length < 1);

        int[] array = new int[length];

        LOGGER.debug("Ввод значений массива");
        for (int i = 0; i < length; i++) {
            System.out.printf("a[%d] = ", i);

            try {
                array[i] = sc.nextInt();
            } catch (InputMismatchException e) {
                LOGGER.error("Некорректный ввод", e);
            }
        }

        return array;
    }

    /**
     * Считывает путь файла
     * @return путь файла
     */
    public static String readFilePath() {
        return sc.nextLine();
    }

    /**
     * Закрывает поток для сканера
     */
    public static void close() {
        sc.close();
    }
}
