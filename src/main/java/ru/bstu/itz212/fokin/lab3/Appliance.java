/**
 * Appliance
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import java.util.Scanner;

/**
 * Представление бытовой техники
 */
public abstract class Appliance {
    public abstract void init(Scanner scanner);
    public abstract String getCost();
}
