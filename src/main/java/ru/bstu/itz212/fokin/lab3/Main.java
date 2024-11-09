package ru.bstu.itz212.fokin.lab3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static int inputCountOfAppliance(Scanner scanner) {
        System.out.print("Введите количество техники: ");
        String input = scanner.nextLine();
        String[] numbers = input.split("\\D+");

        if (numbers.length < 1) {
            LOGGER.warn("Вы не ввели число");
            return 0;
        }

        return numbers[0].isEmpty() ? Integer.parseInt(numbers[1]) : Integer.parseInt(numbers[0]);
    }

    public static Appliance getApplianceType(Scanner scanner) {
        System.out.print("""
                Выберите тип техники:
                1 - газовая плита;
                2 - электронная техника;
                3 - микроволновка.
                """);
        int type = scanner.nextInt();
        scanner.nextLine();

        Appliance appliance = switch (type) {
            case 1 -> new GasStove();
            case 2 -> new ElectronicAppliance();
            case 3 -> new Microwave();
            default -> null;
        };

        if (appliance == null) {
            LOGGER.warn("Некорректный выбор типа техники");
            return null;
        }

        appliance.init(scanner);
        return appliance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = inputCountOfAppliance(scanner);
        List<Appliance> applianceList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Appliance appliance = getApplianceType(scanner);
            applianceList.add(appliance);
        }

        ApplianceComparator comparator = new ApplianceComparator();
        applianceList.sort(comparator);

        System.out.println(applianceList.get(applianceList.size() - 1));
    }
}
