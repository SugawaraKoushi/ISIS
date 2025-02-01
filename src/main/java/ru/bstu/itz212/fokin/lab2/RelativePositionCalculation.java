/**
 * RelativePositionCalculation
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Расчёт взаимного расположения для точки и окружности
 */
public class RelativePositionCalculation {
    private static final Logger LOGGER = LogManager.getLogger(RelativePositionCalculation.class);

    public static void main(String[] args) {
        LOGGER.info("Задание 1. Проверка на пересечение точки и окружности");
        Point p;
        Circle c;
        RelativePosition relativePosition;
        LOGGER.info("Введите путь к файлу данных о точке:");
        String pathToPoint = ConsoleInput.readFilePath();
        LOGGER.info("Введите путь к файлу данных об окружности:");
        String pathToCircle = ConsoleInput.readFilePath();

        // Чтение из файла
        if (!pathToPoint.isEmpty() && !pathToCircle.isEmpty()) {
            p = FileReader.readPointFromFile(pathToPoint);
            c = FileReader.readCircleFromFile(pathToCircle);

            if (p != null && c != null) {
                relativePosition = new RelativePosition(p, c);
                LOGGER.info(relativePosition.intersection());
            }
        } else {
            LOGGER.error("Не найден файл(ы) для считывания данных о точке и/или окружности с путями \"{}\"" +
                    " и \"{}\"", pathToPoint, pathToCircle);
        }

        // Ввод из консоли
        p = ConsoleInput.point();
        c = ConsoleInput.circle();
        relativePosition = new RelativePosition(p, c);
        LOGGER.info(relativePosition.intersection());
    }
}
