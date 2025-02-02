/**
 * GasStove
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import ru.bstu.itz212.fokin.lab3.enums.GasStoveType;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Представление газовой плиты
 */
public class GasStove extends Appliance {
    private GasStoveType type;
    private byte burnerCount;
    private boolean electricIgnition;
    private boolean hasOven;
    private boolean hasGrill;
    private boolean hasTimer;

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите наименование модели: ");
        name = scanner.nextLine();

        System.out.print("Введите производителя: ");
        manufacturer = scanner.nextLine();

        System.out.print("Введите серийный номер: ");
        serialNumber = scanner.nextLine();

        System.out.print("""
                Введите тип плиты:
                1. отдельно стоящая;
                2. встраиваемая;
                3. портативная.
                """);

        int input = scanner.nextInt();
        scanner.nextLine();
        type = switch (input) {
            case 2 -> GasStoveType.BUILT_IN;
            case 3 -> GasStoveType.PORTABLE;
            default -> GasStoveType.FREESTANDING;
        };

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


        System.out.print("Введите количество конфорок: ");
        burnerCount = scanner.nextByte();
        scanner.nextLine();

        System.out.print("Наличие электронного поджога (да/нет): ");
        electricIgnition = parseYesOrNo(scanner.nextLine());

        if (!type.equals(GasStoveType.PORTABLE)) {
            System.out.print("Наличие духовки (да/нет): ");
            hasOven = parseYesOrNo(scanner.nextLine());

            if (hasOven) {
                System.out.print("Наличие гриля в духовке (да/нет): ");
                hasGrill = parseYesOrNo(scanner.nextLine());
            }
        }

        System.out.print("Наличие таймера (да/нет): ");
        hasTimer = parseYesOrNo(scanner.nextLine());

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
        sb.append("Газовая плита - ").append(name).append("\n")
                .append("Изготовитель - ").append(manufacturer).append("\n")
                .append("Серийный номер - ").append(serialNumber).append("\n");

        String type = switch (this.type) {
            case FREESTANDING -> "Отдельно стоящая";
            case BUILT_IN -> "Встраиваемая";
            case PORTABLE -> "Портативная";
        };
        sb.append("Тип - ").append(type).append("\n")
                .append("Дата изготовления - ").append(DATE_FORMAT.format(productionDate)).append("\n")
                .append("Количество конфорок - ").append(burnerCount).append("\n")
                .append("Наличие электронного поджига - ").append(parseBooleanAsYesOrNo(electricIgnition)).append("\n");

        if (!type.equals(GasStoveType.PORTABLE)) {
            sb.append("Наличие духовки - ").append(parseBooleanAsYesOrNo(hasOven)).append("\n");

            if (hasOven) {
                sb.append("Наличие гриля в духовке - ").append(parseBooleanAsYesOrNo(hasGrill)).append("\n");
            }
        }

        sb.append("Наличие таймера - ").append(parseBooleanAsYesOrNo(hasTimer)).append("\n")
                .append("Цена - ").append(getCost()).append("руб. \n");

        return sb.toString();
    }
}
