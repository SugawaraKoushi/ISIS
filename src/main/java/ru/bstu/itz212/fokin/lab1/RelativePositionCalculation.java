package ru.bstu.itz212.fokin.lab1;

public class RelativePositionCalculation {
    public static void main(String[] args) {
        System.out.println("Задание 1. Проверка на пересечение точки и окружности");
        Point p;
        Circle c;
        RelativePosition relativePosition;
        String pathToPoint = ConsoleInput.readFilePath();
        String pathToCircle = ConsoleInput.readFilePath();

        // Чтение из файла
        if (!pathToPoint.isEmpty() && !pathToCircle.isEmpty()) {
            p = FileReader.readPointFromFile(pathToPoint);
            c = FileReader.readCircleFromFile(pathToCircle);
            relativePosition = new RelativePosition(p, c);
            System.out.println(relativePosition.intersection());
        }

        // Ввод из консоли
        p = ConsoleInput.point();
        c = ConsoleInput.circle();
        relativePosition = new RelativePosition(p, c);
        System.out.println(relativePosition.intersection());
        System.out.println();
    }
}
