/**
 * ChangeSignOfNumberPositions
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Определение позиций смены знаков чисел в массиве
 */
public class ChangeSignOfNumberPositions {
    private static final Logger LOGGER = LogManager.getLogger(ChangeSignOfNumberPositions.class);

    /**
     * Определяет список позиций смены знаков чисел в массиве
     * @param numbers массив чисел
     * @return список позиций смены знаков
     */
    public static List<Integer> get(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < numbers.length; i++) {
            boolean changeFromNegativeToPositive = numbers[i - 1] < 0 && numbers[i] > 0;
            boolean changeFromPositiveToNegative = numbers[i - 1] > 0 && numbers[i] < 0;

            if (changeFromNegativeToPositive || changeFromPositiveToNegative) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LOGGER.info("Задание 4. Количество смен знаков в массиве и их позиции");
        LOGGER.info("Введите путь к файлу данных о массиве:");
        String path = ConsoleInput.readFilePath();

        // Чтение из файла
        if (!path.isEmpty()) {
            int[] numbers = FileReader.readArrayFromFile(path);
            List<Integer> changeSignPositions = ChangeSignOfNumberPositions.get(numbers);
            LOGGER.info("Введенный массив: {}", Arrays.toString(numbers));
            LOGGER.info("Количество смен знака: {}", changeSignPositions.size());
            LOGGER.info("Смены позиций: {}", changeSignPositions.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        } else {
            LOGGER.error("Не найден файл для считывания данных о массиве с путем \"{}\"", path);
        }

        // Ввод из консоли
        int[] numbers = ConsoleInput.array();
        List<Integer> changeSignPositions = ChangeSignOfNumberPositions.get(numbers);
        LOGGER.info("Введенный массив: {}", Arrays.toString(numbers));
        LOGGER.info("Количество смен знака: {}", changeSignPositions.size());
        LOGGER.info("Смены позиций: {}", changeSignPositions.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

        ConsoleInput.close();
    }
}
