/**
 * MaxNumberToSumOfItsDigits
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

/**
 * Представление определения максимального отношения числа к сумме его цифр
 */
public class MaxNumberToSumOfItsDigits {
    /**
     * Определение максимального отношения числа к сумме его цифр, используя цикл for
     * @return максимальное значение отношения числа к сумме его цифр
     */
    public static double calculateUsingForLoop() {
        double max = 0;

        for (int i = 100; i < 1000; i++) {
            int sum = getNumberSumDigits(i);
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
            int sum = getNumberSumDigits(i);
            double ratio = (double) i / sum;
            max = Math.max(max, ratio);
        }

        return max;
    }

    /**
     * Получение суммы цифр 3х значного числа
     * @param number число
     * @return сумма цифр
     */
    private static int getNumberSumDigits(int number) {
        int sum = 0;
        sum += number % 10;
        sum += number / 10 % 10;
        sum += number / 100;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Задание 3. Максимальное отношение числа к сумме его цифр");
        double maxRatio = MaxNumberToSumOfItsDigits.calculateUsingForLoop();
        System.out.printf("Цикл for: %.2f%n", maxRatio);
        maxRatio = MaxNumberToSumOfItsDigits.calculateUsingWhileLoop();
        System.out.printf("Цикл while: %.2f%n", maxRatio);
        System.out.println();
    }
}
