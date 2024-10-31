/**
 * GasStove
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import java.util.Date;
import java.util.Scanner;


/**
 * Представление газовой плиты
 */
public class GasStove extends Appliance {
    private String name;
    private String manufacturer;
    private String serialNumber;
    private String type;
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

        System.out.println("Введите тип плиты: ");
    }

    @Override
    public String getCost() {
        return "";
    }

    @Override
    public String toString() {
        return "";
    }
}
