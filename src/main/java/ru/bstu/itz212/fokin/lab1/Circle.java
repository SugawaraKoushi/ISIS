/**
 * Circle
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab1;

/**
 * Представление окружности
 */
public class Circle {
    private Point center;
    private double radius;

    public Circle (double x, double y, double radius) {
        center = new Point(x, y);
        this.radius = Math.abs(radius);
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Окружность r = %.3f, x = %.3f, y = %.3f", radius, center.getX(), center.getY());
    }
}
