/**
 * Microwave
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;
import ru.bstu.itz212.fokin.lab3.enums.MicrowaveControlType;
import ru.bstu.itz212.fokin.lab3.enums.MicrowaveType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Представление микроволновой печи
 */
public class Microwave extends ElectronicAppliance {
    private String name;
    private String manufacturer;
    private String serialNumber;
    private MicrowaveType type;
    private Date productionDate;
    private MicrowaveControlType controlType;
    private int volume;
    private double energyConsumption;
    private boolean defrost;
    private double price;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите микроволновой печи: ");
        name = scanner.nextLine();

        System.out.print("Введите производителя: ");
        manufacturer = scanner.nextLine();

        System.out.print("Введите серийный номер: ");
        serialNumber = scanner.nextLine();

        System.out.print("""
                Введите тип печи:
                1. соло;
                2. гриль;
                3. конвекция.
                """);

        int input = scanner.nextInt();
        scanner.nextLine();
        type = switch (input) {
            case 1 -> MicrowaveType.SOLO;
            case 2 -> MicrowaveType.GRILL;
            case 3 -> MicrowaveType.CONVECTION;
            default -> MicrowaveType.SOLO;
        };

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

        System.out.print("""
                Введите тип управления:
                1. сенсорный;
                2. механический;
                3. электронный.
                """);

        input = scanner.nextInt();
        scanner.nextLine();
        controlType = switch (input) {
            case 2 -> MicrowaveControlType.MECHANIC;
            case 3 -> MicrowaveControlType.ELECTRONIC;
            default -> MicrowaveControlType.SENSOR;
        };

        System.out.print("Введите объем: ");
        volume = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите мощность: ");
        energyConsumption = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Наличие режима разморозки (да/нет): ");
        defrost = parseYesOrNo(scanner.nextLine());

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
        sb.append("Микроволновая печь - ").append(name).append("\n")
                .append("Изготовитель - ").append(manufacturer).append("\n")
                .append("Серийный номер - ").append(serialNumber).append("\n");

        String type = switch (this.type) {
            case SOLO -> "Соло";
            case GRILL -> "Гриль";
            case CONVECTION -> "Конвекция";
        };

        sb.append("Тип - ").append(type).append("\n")
                .append("Дата изготовления - ").append(dateFormatter.format(productionDate)).append("\n");

        String controlType = switch (this.controlType) {
            case SENSOR -> "Сенсорный";
            case MECHANIC -> "Механический";
            case ELECTRONIC -> "Электронный";
        };

        sb.append("Тип управления - ").append(controlType).append("\n")
                .append("Объем - ").append(volume).append("л. \n")
                .append("Мощность - ").append(energyConsumption).append("Вт. \n");

        if (defrost) {
            sb.append("Наличие режима разморозки - ").append(parseBooleanAsYesOrNo(defrost)).append("\n");
        }

        sb.append("Цена - ").append(getCost()).append("руб. \n");

        return sb.toString();
    }

    private boolean parseYesOrNo(String input) {
        input = input.toLowerCase();

        return input.equals("да");
    }

    private String parseBooleanAsYesOrNo(boolean flag) {
        return flag ? "да" : "нет";
    }
}
