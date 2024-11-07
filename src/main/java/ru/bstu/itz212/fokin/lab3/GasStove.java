/**
 * GasStove
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import ru.bstu.itz212.fokin.lab3.enums.GasStoveType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * Представление газовой плиты
 */
public class GasStove extends Appliance {
    private String name;
    private String manufacturer;
    private String serialNumber;
    private GasStoveType type;
    private Date productionDate;
    private double price;
    private byte burnerCount;
    private boolean electricIgnition;
    private boolean oven;
    private boolean grill;
    private boolean timer;

    @Override
    public void init(Scanner scanner) {
        System.out.print("Введите название газовой плиты: ");
        name = scanner.nextLine();

        System.out.println("Введите производителя газовой плиты: ");
        manufacturer = scanner.nextLine();

        System.out.println("Введите серийный номер: ");
        serialNumber = scanner.nextLine();

        System.out.println("""
                Введите тип плиты:
                1. отдельно стоящая;
                2. встраиваемая;
                3. портативная.
                """);

        int input = scanner.nextInt();
        type = switch (input) {
            case 1 -> GasStoveType.FREESTANDING;
            case 2 -> GasStoveType.BUILT_IN;
            case 3 -> GasStoveType.PORTABLE;
            default -> GasStoveType.FREESTANDING;
        };

        System.out.println("Введите дату производства (дд.мм.гггг): ");
        String dateStr = scanner.nextLine();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

        boolean inputError;
        do {
            try {
                productionDate = dateFormatter.parse(dateStr);
                inputError = false;
            } catch (ParseException e) {
                System.out.println("Некорректный ввод даты. Дата должна быть в формате дд.мм.гггг");
                inputError = true;
            }
        } while (inputError);


        System.out.println("Введите количество конфорок: ");
        burnerCount = scanner.nextByte();

        System.out.println("Наличие электронного поджога (да/нет): ");
        electricIgnition = parseYesOrNo(scanner.nextLine());

        if (!type.equals(GasStoveType.PORTABLE)) {
            System.out.println("Наличие духовки (да/нет): ");
            oven = parseYesOrNo(scanner.nextLine());

            if (oven) {
                System.out.println("Наличие гриля в духовке (да/нет): ");
                grill = parseYesOrNo(scanner.nextLine());
            }
        }

        System.out.println("Наличие таймера (да/нет): ");
        timer = parseYesOrNo(scanner.nextLine());

        System.out.println("Введите стоимость: ");
        price = scanner.nextDouble();
    }

    @Override
    public String getCost() {
        return String.format("%f.3 руб.", price);
    }

    @Override
    public String toString() {
        return "";
    }

    private boolean parseYesOrNo(String input) {
        input = input.toLowerCase();

        return input.equals("да");
    }
}
