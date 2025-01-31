/**
 * ChangeSignOfNumberPositions
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Определение позиций смены знаков чисел в массиве
 */
public class ChangeSignOfNumberPositions {
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
        System.out.println("Задание 4. Количество смен знаков в массиве и их позиции");
        String path = ConsoleInput.readFilePath();

        // Чтение из файла
        if (!path.isEmpty()) {
            int[] numbers = FileReader.readArrayFromFile(path);
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
