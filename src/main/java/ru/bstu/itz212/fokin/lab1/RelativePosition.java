/**
 * RelativePosition
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

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
        double distance = Math.pow((point.getX() - circle.getCenter().getX()), 2)
                + Math.pow((point.getY() - circle.getCenter().getY()), 2);
        distance = Math.abs(distance);

        if (circle.getRadius() >= distance) {
            return String.format("%s и %s %s", point.toString(), circle.toString(), ARE_INTERSECT);
        }

        return String.format("%s и %s %s", point.toString(), circle.toString(), ARE_NOT_INTERSECT);
    }
}
