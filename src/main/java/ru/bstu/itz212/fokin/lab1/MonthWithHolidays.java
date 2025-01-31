package ru.bstu.itz212.fokin.lab1;

import java.net.URL;

public class MonthWithHolidays {
    public static void main(String[] args) {
        System.out.println("Задание 2. Вывод праздников введенного месяца");
        String path = ConsoleInput.readFilePath();
        Month month;

        // Чтение из файла
        if (!path.isEmpty()) {
            month = FileReader.readMonthFromFile(path);
            System.out.println(month);
        }

        // Ввод из консоли
        month = ConsoleInput.month();
        System.out.println(month);
        System.out.println();
    }
}
