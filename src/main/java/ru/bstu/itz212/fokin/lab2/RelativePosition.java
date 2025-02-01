/**
 * RelativePosition
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

/**
 * Представление определения относительного расположения точки и окружности
 */
public class RelativePosition {
    private final static String ARE_INTERSECT = "пересекаются";
    private final static String ARE_NOT_INTERSECT = "не пересекаются";

    private Point point;
    private Circle circle;

    public RelativePosition(Point p, Circle c) {
        point = p;
        circle = c;
    }

    /**
     * Определение пересечения точки и окружности
     * @return пересечение точки и окружности
     */
    public String intersection() {
        double distance = Math.pow((circle.getCenter().getX() - point.getX()), 2)
                + Math.pow((circle.getCenter().getY() - point.getY()), 2);
        distance = Math.sqrt(distance);

        if (circle.getRadius() >= distance) {
            return String.format("%s и %s %s", point.toString(), circle.toString(), ARE_INTERSECT);
        }

        return String.format("%s и %s %s", point.toString(), circle.toString(), ARE_NOT_INTERSECT);
    }
}
