/**
 * ElectronicAppliance
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import ru.bstu.itz212.fokin.lab3.enums.ElectronicApplianceControlType;

import java.text.ParseException;
import java.util.Scanner;


/**
 * Представление электронной техники
 */
public class ElectronicAppliance extends Appliance {
    protected String powerSource;
    protected double energyConsumption;
    protected ElectronicApplianceControlType controlType;

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите наименование модели: ");
        name = scanner.nextLine();

        System.out.print("Введите производителя: ");
        manufacturer = scanner.nextLine();

        System.out.print("Введите серийный номер: ");
        serialNumber = scanner.nextLine();

        boolean inputError;
        do {
            try {
                System.out.print("Введите дату производства (дд.мм.гггг): ");
                String dateStr = scanner.nextLine();
                productionDate = DATE_FORMAT.parse(dateStr);
                inputError = false;
            } catch (ParseException e) {
                System.out.println("Некорректный ввод даты. Дата должна быть в формате дд.мм.гггг");
                inputError = true;
            }
        } while (inputError);

        System.out.print("""
                Введите тип управления:
                1. сенсорный;
                2. механический;
                3. электронный.
                """);

        int input = scanner.nextInt();
        scanner.nextLine();
        controlType = switch (input) {
            case 2 -> ElectronicApplianceControlType.MECHANIC;
            case 3 -> ElectronicApplianceControlType.ELECTRONIC;
            default -> ElectronicApplianceControlType.SENSOR;
        };

        System.out.print("Введите тип источник питания техники: ");
        powerSource = scanner.nextLine();

        System.out.print("Введите мощность (Вт): ");
        energyConsumption = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите стоимость (руб): ");
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
        sb.append("Название - ").append(name).append("\n")
                .append("Изготовитель - ").append(manufacturer).append("\n")
                .append("Серийный номер - ").append(serialNumber).append("\n")
                .append("Дата изготовления - ").append(DATE_FORMAT.format(productionDate)).append("\n")
                .append("Источник питания - ").append(powerSource).append("\n")
                .append("Мощность - ").append(energyConsumption).append("Вт. \n")
                .append("Цена - ").append(getCost()).append("руб. \n");

        return sb.toString();
    }
}
