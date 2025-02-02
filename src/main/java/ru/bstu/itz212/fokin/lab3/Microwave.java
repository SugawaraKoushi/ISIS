/**
 * Microwave
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import ru.bstu.itz212.fokin.lab3.enums.ElectronicApplianceControlType;
import ru.bstu.itz212.fokin.lab3.enums.MicrowaveType;

import java.util.Scanner;

/**
 * Представление микроволновой печи
 */
public class Microwave extends ElectronicAppliance {
    private MicrowaveType type;
    private ElectronicApplianceControlType controlType;
    private int volume;
    private boolean defrost;

    @Override
    public void init(Scanner scanner) {
        super.init(scanner);

        System.out.print("""
                Введите тип микроволновой печи:
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

        System.out.print("Введите объем (л.): ");
        volume = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Наличие режима разморозки (да/нет): ");
        defrost = parseYesOrNo(scanner.nextLine());
    }

    @Override
    public String getCost() {
        return super.getCost();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Микроволновая печь - ").append(name).append("\n")
                .append("Изготовитель - ").append(manufacturer).append("\n")
                .append("Серийный номер - ").append(serialNumber).append("\n")
                .append("Тип - ").append(type).append("\n")
                .append("Дата изготовления - ").append(DATE_FORMAT.format(productionDate)).append("\n")
                .append("Объем - ").append(volume).append("л.\n")
                .append("Мощность - ").append(energyConsumption).append("Вт.\n");

        String type = switch (this.type) {
            case SOLO -> "Соло";
            case GRILL -> "Гриль";
            case CONVECTION -> "Конвекция";
        };

        String controlType = switch (this.controlType) {
            case SENSOR -> "Сенсорный";
            case MECHANIC -> "Механический";
            case ELECTRONIC -> "Электронный";
        };

        if (defrost) {
            sb.append("Наличие режима разморозки - ").append(parseBooleanAsYesOrNo(defrost)).append("\n");
        }

        sb.append("Тип управления - ").append(controlType).append("\n")
                .append("Цена - ").append(getCost()).append("руб. \n");

        return sb.toString();
    }
}
