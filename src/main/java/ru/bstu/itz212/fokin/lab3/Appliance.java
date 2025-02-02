/**
 * Appliance
 * <p>
 * version 1.0
 * <p>
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Представление бытовой техники
 */
public abstract class Appliance {
    protected String name;
    protected String manufacturer;
    protected String serialNumber;
    protected Date productionDate;
    protected double price;
    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public abstract void init(Scanner scanner);

    public abstract String getCost();

    protected static boolean parseYesOrNo(String input) {
        input = input.toLowerCase();
        return input.equals("да");
    }

    protected static String parseBooleanAsYesOrNo(boolean flag) {
        return flag ? "да" : "нет";
    }
}
