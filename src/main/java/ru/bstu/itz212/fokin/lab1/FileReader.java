/**
 * FileReader
 *
 * version 1.0
 *
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
     * Определение порядкового номера месяца чтением из файла
     * @param path путь к файлу
     * @return порядковый номер месяца
     */
    public static int readMonthFromFile(String path) {
        File file = new File(path);
        int month = -1;
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            if (!sc.hasNextLine()) return month;

            month = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return month;
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
