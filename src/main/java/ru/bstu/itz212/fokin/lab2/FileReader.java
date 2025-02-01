/**
 * FileReader
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Создание точки чтением из файла
     * @param path путь к файлу
     * @return точка
     */
    public static Point readPointFromFile(String path) {
        File file = new File(path);
        Point p = null;
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            double x;
            double y;

            if (!sc.hasNextLine()) {
                LOGGER.debug("Файл \"{}\" пуст", path);
                return p;
            }

            x = sc.nextDouble();
            y = sc.nextDouble();
            p = new Point(x, y);
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл по указанному пути {} не найден", path, e);
        } finally {
            // Если поток ввода был открыт, то его нужно закрыть
            if (sc != null) {
                sc.close();
            }
        }

        return p;
    }

    /**
     * Создание окружности чтением из файла
     * @param path путь к файлу
     * @return окружность
     */
    public static Circle readCircleFromFile(String path) {
        File file = new File(path);
        Circle c = null;
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            double x;
            double y;
            double r;

            if (!sc.hasNextLine()) {
                LOGGER.debug("Файл \"{}\" пуст", path);
                return c;
            }

            x = sc.nextDouble();
            y = sc.nextDouble();
            r = sc.nextDouble();
            c = new Circle(x, y, r);
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл по указанному пути {} не найден", path, e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return c;
    }

    /**
     * Определение порядкового номера месяца чтением из файла
     * @param path путь к файлу
     * @return порядковый номер месяца
     */
    public static Month readMonthFromFile(String path) {
        File file = new File(path);
        int month = 0;
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            if (!sc.hasNextLine()) {
                LOGGER.error("Файл пуст");
                month = -1;
            } else {
                month = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл по указанному пути {} не найден", path, e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return new Month(month);
    }

    /**
     * Создание массива чисел чтением из файла
     * @param path путь к файлу
     * @return массив чисел
     */
    public static int[] readArrayFromFile(String path) {
        File file = new File(path);
        Scanner sc = null;
        int[] array = new int[0];

        try {
            sc = new Scanner(file);

            if (!sc.hasNextLine()) {
                LOGGER.debug("Файл \"{}\" пуст", path);
                return array;
            }

            int length = sc.nextInt();

            if (length < 1) {
                LOGGER.warn("Нулевая или отрицательная длина массива");
                return array;
            }

            array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл по указанному пути {} не найден", path, e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return array;
    }
}
