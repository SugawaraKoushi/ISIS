/**
 * ElectronicAppliance
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import java.util.Date;
import java.util.Scanner;


/**
 * Представление электронной техники
 */
public class ElectronicAppliance extends Appliance {
    private String name;
    private String manufacturer;
    private String serialNumber;
    private String deviceType;
    private String powerSource;
    private String category;
    private Date productionDate;
    private double price;


    @Override
    public void init(Scanner scanner) {

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
