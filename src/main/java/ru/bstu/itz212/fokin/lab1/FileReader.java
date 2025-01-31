/**
 * FileReader
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

import java.io.File;
import java.util.Scanner;

public class FileReader {
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

            if (!sc.hasNextLine()) return p;

            x = sc.nextDouble();
            y = sc.nextDouble();
            p = new Point(x, y);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

            if (!sc.hasNextLine()) return c;

            x = sc.nextDouble();
            y = sc.nextDouble();
            r = sc.nextDouble();
            c = new Circle(x, y, r);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return c;
    }

    /**
     * Создание месяца чтением его порядкового номера из файла
     * @param path путь к файлу
     * @return месяц
     */
    public static Month readMonthFromFile(String path) {
        File file = new File(path);
        int month = 0;
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            if (!sc.hasNextLine()) {
                month = -1;
            } else {
                month = sc.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

            if (!sc.hasNextLine()) return array;

            int length = sc.nextInt();

            if (length < 1) return array;

            array = new int[length];

            for (int i = 0; i < length; i++) {
                array[i] = sc.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return array;
    }
}
