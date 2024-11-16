package ru.bstu.itz212.fokin.lab5.repositories;

import ru.bstu.itz212.fokin.lab5.models.CarOwner;

public class CarOwnerRepository extends CrudRepository<CarOwner> {
    @Override
    public int create(CarOwner carOwner) {
        return 0;
    }

    @Override
    public CarOwner get(int id) {
        return null;
    }

    @Override
    public int update(CarOwner carOwner) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
