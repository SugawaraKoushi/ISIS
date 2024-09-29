/**
 * Month
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Представление месяца. Имеет название и список праздников
 */
public class Month {
    private List<Holiday> holidays;
    private String name;
    private static final String MONTH_DOES_NOT_EXIST = "Не существует такого месяца месяца";

    public Month(int month) {
        List<Holiday> holidays = new ArrayList<>();

        switch (month) {
            case 1:
                holidays.add(new Holiday(1, "Новый год"));
                holidays.add(new Holiday(7, "Рождество Христово"));
                this.name = "Январь";
                this.holidays = holidays;
                break;

            case 2:
                holidays.add(new Holiday(23, "День защитника Отечества"));
                this.name = "Февраль";
                this.holidays = holidays;
                break;

            case 3:
                holidays.add(new Holiday(8, "Международный женский день"));
                this.name = "Март";
                this.holidays = holidays;
                break;

            case 4:
                this.name = "Апрель";
                this.holidays = holidays;
                break;

            case 5:
                holidays.add(new Holiday(1, "Праздник Весны и Труда"));
                holidays.add(new Holiday(9, "День Победы"));
                this.name = "Май";
                this.holidays = holidays;
                break;

            case 6:
                holidays.add(new Holiday(12, "День России"));
                this.name = "Июнь";
                this.holidays = holidays;
                break;

            case 7:
                this.name = "Июль";
                this.holidays = holidays;
                break;

            case 8:
                this.name = "Август";
                this.holidays = holidays;
                break;

            case 9:
                this.name = "Сентябрь";
                this.holidays = holidays;
                break;

            case 10:
                this.name = "Октябрь";
                this.holidays = holidays;
                break;

            case 11:
                holidays.add(new Holiday(4, "День народного единства"));
                this.name = "Ноябрь";
                this.holidays = holidays;
                break;

            case 12:
                this.name = "Декабрь";
                this.holidays = holidays;
                break;

            default:
                this.name = MONTH_DOES_NOT_EXIST;
                this.holidays = holidays;
                break;
        }
    }

    @Override
    public String toString() {
        if (this.name.equals(MONTH_DOES_NOT_EXIST))
            return MONTH_DOES_NOT_EXIST;

        if (holidays.isEmpty())
            return String.format("В %s отсутствуют праздники", name);

        StringBuilder sb = new StringBuilder();

        for (Holiday holiday : holidays) {
            sb.append(name).append(" ").append(holiday);
        }

        return sb.toString();
    }
}
