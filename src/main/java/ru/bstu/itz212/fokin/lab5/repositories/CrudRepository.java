package ru.bstu.itz212.fokin.lab5.repositories;


public abstract class CrudRepository<T> {
    public abstract int create(T t);
    public abstract T get(int id);
    public abstract int update(T t);
    public abstract int delete(int id);
}
