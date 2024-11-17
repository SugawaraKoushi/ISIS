package ru.bstu.itz212.fokin.lab5.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesConfigure {
    private final Connection connection;

    public TablesConfigure(Connection connection) {
        this.connection = connection;
    }

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
                        "LicensePlate" text NOT NULL,
                        "OwnerLastName" text NOT NULL,
                        "OwnerFirstName" text NOT NULL,
                        "OwnerMiddleName" text,
                        PRIMARY KEY ("Id")
                    )
                    """;

            String createCarOwnersTableQuery = """
                    CREATE TABLE IF NOT EXISTS "CarOwners"
                    (
                        "Id" integer NOT NULL,
                        "Gender" boolean NOT NULL,
                        "LastName" text NOT NULL,
                        "FirstName" text NOT NULL,
                        "MiddleName" text,
                        PRIMARY KEY ("Id")
                    );
                    """;

            statement.execute(createCarsTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
