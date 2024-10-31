/**
 * Microwave
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import ru.bstu.itz212.fokin.lab3.enums.MicrowaveControlType;
import java.util.Scanner;

/**
 * Представление микроволновой печи
 */
public class Microwave extends ElectronicAppliance {
    private String name;
    private String manufacturer;
    private String serialNumber;
    private String type;
    private MicrowaveControlType controlType;
    private int volume;
    private double price;
    private double energyConsumption;
    private boolean defrost;

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
