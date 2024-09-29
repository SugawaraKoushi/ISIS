package ru.bstu.itz212.fokin.lab2;

import java.util.ArrayList;
import java.util.List;

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
}
