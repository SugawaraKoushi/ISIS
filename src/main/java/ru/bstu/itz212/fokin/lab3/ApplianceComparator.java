package ru.bstu.itz212.fokin.lab3;

import java.util.Comparator;

public class ApplianceComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Appliance a1 = (Appliance) o1;
        Appliance a2 = (Appliance) o2;
        double cost1 = Double.parseDouble(a1.getCost().replace(',', '.'));
        double cost2 = Double.parseDouble(a2.getCost().replace(',', '.'));
        return Double.compare(cost1, cost2);
    }
}
