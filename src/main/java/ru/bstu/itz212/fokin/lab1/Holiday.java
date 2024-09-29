/**
 * Holiday
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

/**
 * Предстваление дня праздника
 */
public class Holiday {
    private int day;
    private String name;

    public Holiday(int day, String name) {
        this.day = day;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d - %s\n", day, name);
    }
}
