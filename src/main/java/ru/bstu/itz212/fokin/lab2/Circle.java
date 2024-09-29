/**
 * Circle
 *
 * version 1.0
 *
 * (c) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Представление окружности
 */
public class Circle {
    private Point center;
    private double radius;
    private static final Logger LOGGER = LogManager.getLogger();

    public Circle (double x, double y, double radius) {
        center = new Point(x, y);

        if (radius < 0) LOGGER.warn("Окружность имеет отрицательный радиус");

        LOGGER.debug("Берем значение радиуса по модулю");
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
