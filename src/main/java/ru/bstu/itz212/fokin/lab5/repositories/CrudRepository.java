package ru.bstu.itz212.fokin.lab5.repositories;


import java.sql.Connection;

public abstract class CrudRepository<T> {
    private Connection connection;

    public CrudRepository(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract int create(T t);
    public abstract T get(int id);
    public abstract int update(T t);
    public abstract int delete(int id);
}
