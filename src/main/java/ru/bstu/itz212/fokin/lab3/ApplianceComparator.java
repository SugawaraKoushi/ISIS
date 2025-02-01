/**
 * ApplianceComparator
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab3;

import java.util.Comparator;

/**
 * Сравнивает бытовую технику
 */
public class ApplianceComparator implements Comparator<Appliance> {
    /**
     * Сравнивает объекты бытовой техники по их стоимости
     * @param a1 первая техника.
     * @param a2 вторая техника.
     * @return {@code 0} если значения стоимости {@code a1} и {@code a2} равны;
     * значение меньше {@code 0}, если стоимость {@code a1} меньше, чем стоимость {@code a2};
     * значение больше {@code 0}, если стоимость {@code a1} больше, чем стоимость {@code a2};
     */
    @Override
    public int compare(Appliance a1, Appliance a2) {
        double cost1 = Double.parseDouble(a1.getCost().replace(',', '.'));
        double cost2 = Double.parseDouble(a2.getCost().replace(',', '.'));
        return Double.compare(cost1, cost2);
    }
}
