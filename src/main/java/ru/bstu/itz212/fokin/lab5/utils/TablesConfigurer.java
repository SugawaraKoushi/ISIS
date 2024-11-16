package ru.bstu.itz212.fokin.lab5.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesConfigurer {
    private Connection connection;

    public TablesConfigurer(Connection connection) {
        this.connection = connection;
    }

    public void createTablesIfNotExists() {
        try {
            Statement statement = connection.createStatement();
            String createCarsTableQuery = """
                    CREATE TABLE IF NOT EXISTS "Cars"
                    (
                        "Id" integer NOT NULL,
                        "Brand" text NOT NULL,
                        "Model" text NOT NULL,
                        "Color" text NOT NULL,
                        "LicensePlate" character varying(9)[] NOT NULL,
                        "OwnerId" integer NOT NULL,
                        PRIMARY KEY ("Id"),
                        FOREIGN KEY ("OwnerId")
                            REFERENCES public."CarOwners" ("Id") MATCH SIMPLE
                            ON UPDATE NO ACTION
                            ON DELETE NO ACTION
                            NOT VALID
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

            statement.execute(createCarOwnersTableQuery);
            statement.execute(createCarsTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
