/**
 * WashingMachine
 * <p>
 * version 1.0
 * <p>
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import ru.bstu.itz212.fokin.lab3.enums.WashingMachineLoadingType;

import java.util.Scanner;

/**
 * Представление стиральной машины
 */
public class WashingMachine extends ElectronicAppliance {
    private WashingMachineLoadingType loadingType;
    private double maxLoad;
    private String energyEfficiency;
    private boolean hasDryFunction;
    private boolean hasLeakProtection;

    @Override
    public void init(Scanner scanner) {
        super.init(scanner);

        System.out.print("""
                Введите тип загрузки:
                1. фронтальный;
                2. вертикальный.
                """);

        int input = scanner.nextInt();
        scanner.nextLine();

        loadingType = (input == 1) ? WashingMachineLoadingType.FRONT : WashingMachineLoadingType.VERTICAL;

        System.out.print("Введите максимальную загрузку белья: ");
        maxLoad = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите класс энергоэффективности(А+++, А++ и т.д.): ");
        energyEfficiency = scanner.nextLine();

        System.out.print("Наличие режима сушки (да/нет): ");
        hasDryFunction = parseYesOrNo(scanner.nextLine());

        System.out.print("Наличие защиты от протечки (да/нет): ");
        hasLeakProtection = parseYesOrNo(scanner.nextLine());
    }

    @Override
    public String getCost() {
        return super.getCost();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Стиральная машина - ").append(name).append("\n")
                .append("Изготовитель - ").append(manufacturer).append("\n")
                .append("Серийный номер - ").append(serialNumber).append("\n")
                .append("Дата изготовления - ").append(DATE_FORMAT.format(productionDate)).append("\n")
                .append("Мощность - ").append(energyConsumption).append("Вт.\n")
                .append("Максимальная загрузка белья - ").append(maxLoad).append("кг.\n")
                .append("Класс энергоэффективности - ").append(energyEfficiency).append("\n");

        String controlType = switch (this.controlType) {
            case SENSOR -> "Сенсорный";
            case MECHANIC -> "Механический";
            case ELECTRONIC -> "Электронный";
        };

        String loadingType = switch (this.loadingType) {
            case FRONT -> "Фронтальный";
            case VERTICAL -> "Вериткальный";
        };

        if (hasDryFunction) {
            sb.append("Наличие режима сушки - ").append(parseBooleanAsYesOrNo(hasDryFunction)).append("\n");
        }

        if (hasLeakProtection) {
            sb.append("Наличие защиты от протечки - ").append(parseBooleanAsYesOrNo(hasLeakProtection)).append("\n");
        }

        sb.append("Тип управления - ").append(controlType).append("\n")
                .append("Цена - ").append(getCost()).append("руб. \n");

        return sb.toString();
    }
}
