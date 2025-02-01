/**
 * MonthWithHolidays
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Месяц и его праздники
 */
public class MonthWithHolidays {
    private static final Logger LOGGER = LogManager.getLogger(MonthWithHolidays.class);

    public static void main(String[] args) {
        LOGGER.info("Задание 2. Вывод праздников введенного месяца");
        LOGGER.info("Введите путь к файлу данных о месяце:");
        String path = ConsoleInput.readFilePath();
        Month month;

        // Чтение из файла
        if (!path.isEmpty()) {
            month = FileReader.readMonthFromFile(path);
            LOGGER.info(month);
        } else {
            LOGGER.error("Не найден файл для считывания данных о месяце с путем \"{}\"", path);
        }

        // Ввод из консоли
        month = ConsoleInput.month();
        LOGGER.info(month);
    }
}
