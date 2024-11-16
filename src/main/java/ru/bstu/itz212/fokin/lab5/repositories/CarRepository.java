package ru.bstu.itz212.fokin.lab5.repositories;

import ru.bstu.itz212.fokin.lab5.models.Car;

public class CarRepository extends CrudRepository<Car>{
    @Override
    public int create(Car car) {
        return 0;
    }

    @Override
    public Car get(int id) {
        return null;
    }

    @Override
    public int update(Car car) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
