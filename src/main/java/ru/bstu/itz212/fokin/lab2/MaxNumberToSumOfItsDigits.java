/**
 * MaxNumberToSumOfItsDigits
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Представление определения максимального отношения числа к сумме его цифр
 */
public class MaxNumberToSumOfItsDigits {
    private static final Logger LOGGER = LogManager.getLogger(MaxNumberToSumOfItsDigits.class);

    /**
     * Определение максимального отношения числа к сумме его цифр, используя цикл for
     * @return максимальное значение отношения числа к сумме его цифр
     */
    public static double calculateUsingForLoop() {
        double max = 0;

        for (int i = 100; i < 1000; i++) {
            LOGGER.debug("Определение суммы цифр для числа {}", i);
            int sum = getNumberSumDigits(i);
            LOGGER.debug("Определение отношения числа {} к сумме его цифр {}", i, sum);
            double ratio = (double) i / sum;
            max = Math.max(max, ratio);
        }

        return max;
    }

    /**
     * Определение максимального отношения числа к сумме его цифр, используя цикл while
     * @return максимальное значение отношения числа к сумме его цифр
     */
    public static double calculateUsingWhileLoop() {
        double max = 0;
        int i = 99;

        while (++i < 1000) {
            LOGGER.debug("Определение суммы цифр для числа {}", i);
            int sum = getNumberSumDigits(i);
            LOGGER.debug("Определение отношения числа {} к сумме его цифр {}", i, sum);
            double ratio = (double) i / sum;
            max = Math.max(max, ratio);
        }

        return max;
    }

    private static int getNumberSumDigits(int number) {
        int sum = 0;
        sum += number % 10;
        sum += number / 10 % 10;
        sum += number / 100;
        return sum;
    }

    public static void main(String[] args) {
        LOGGER.info("Задание 3. Максимальное отношение числа к сумме его цифр");
        double maxRatio = MaxNumberToSumOfItsDigits.calculateUsingForLoop();
        LOGGER.info("Цикл for: {}", maxRatio);
        maxRatio = MaxNumberToSumOfItsDigits.calculateUsingWhileLoop();
        LOGGER.info("Цикл while: {}", maxRatio);
    }
}
