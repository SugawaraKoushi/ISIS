/**
 *  CrudRepository
 *
 *  version 1.0
 *
 *  (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab5.repositories;

import java.sql.Connection;

/**
 * Абстрактный класс CRUD репозитория
 * @param <T> тип данных для репозитория
 */
public abstract class CrudRepository<T> {
    protected Connection connection;

    public CrudRepository(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract T create(T t);
    public abstract T get(int id);
    public abstract void update(T t);
    public abstract void delete(T t);
}
