/**
 * TablesConfigure
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */
package ru.bstu.itz212.fokin.lab5.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Конфигуратор таблиц для БД
 */
public class TablesConfigure {
    private final Connection connection;

    public TablesConfigure(Connection connection) {
        this.connection = connection;
    }

    /**
     * Создает таблицу Cars в БД, если та не существует
     */
    public void createTablesIfNotExists() {
        try {
            Statement statement = connection.createStatement();
            String createCarsTableQuery = """
                    CREATE TABLE IF NOT EXISTS "Cars"
                    (
                        "Id" SERIAL NOT NULL,
                        "Brand" text NOT NULL,
                        "Model" text NOT NULL,
                        "Color" text NOT NULL,
                        "LicensePlate" varchar(9) NOT NULL,
                        "OwnerLastName" text NOT NULL,
                        "OwnerFirstName" text NOT NULL,
                        "OwnerMiddleName" text,
                        PRIMARY KEY ("Id"),
                        UNIQUE ("LicensePlate")
                    )
                    """;

            statement.execute(createCarsTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
