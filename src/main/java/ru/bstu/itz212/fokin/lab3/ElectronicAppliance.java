/**
 * ElectronicAppliance
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Представление электронной техники
 */
public class ElectronicAppliance extends Appliance {
    private String name;
    private String manufacturer;
    private String serialNumber;
    private String type;
    private Date productionDate;
    private String powerSource;
    private double energyConsumption;
    private String category;
    private double price;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите название электронной техники: ");
        name = scanner.nextLine();

        System.out.print("Введите производителя: ");
        manufacturer = scanner.nextLine();

        System.out.print("Введите серийный номер: ");
        serialNumber = scanner.nextLine();

        System.out.print("Введите тип техники: ");
        type = scanner.nextLine();

        boolean inputError;
        do {
            try {
                System.out.print("Введите дату производства (дд.мм.гггг): ");
                String dateStr = scanner.nextLine();
                productionDate = dateFormatter.parse(dateStr);
                inputError = false;
            } catch (ParseException e) {
                System.out.println("Некорректный ввод даты. Дата должна быть в формате дд.мм.гггг");
                inputError = true;
            }
        } while (inputError);


        System.out.print("Введите тип источник питания техники: ");
        powerSource = scanner.nextLine();

        System.out.print("Введите мощность: ");
        energyConsumption = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите категорию техники: ");
        category = scanner.nextLine();

        System.out.print("Введите стоимость: ");
        price = scanner.nextDouble();
        scanner.nextLine();
    }

    @Override
    public String getCost() {
        return String.format("%.3f", price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Электронная техника - ").append(type).append("\n")
                .append("Название - ").append(name).append("\n")
                .append("Изготовитель - ").append(manufacturer).append("\n")
                .append("Серийный номер - ").append(serialNumber).append("\n")
                .append("Тип - ").append(type).append("\n")
                .append("Дата изготовления - ").append(dateFormatter.format(productionDate)).append("\n")
                .append("Источник питания - ").append(getCost()).append("\n")
                .append("Мощность - ").append(energyConsumption).append("Вт. \n")
                .append("Категорияы - ").append(getCost()).append("\n")
                .append("Цена - ").append(getCost()).append("руб. \n");

        return sb.toString();
    }
}
