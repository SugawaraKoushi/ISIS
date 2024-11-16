package ru.bstu.itz212.fokin.lab5;

import ru.bstu.itz212.fokin.lab5.models.Car;
import ru.bstu.itz212.fokin.lab5.models.CarOwner;
import ru.bstu.itz212.fokin.lab5.repositories.CarOwnerRepository;
import ru.bstu.itz212.fokin.lab5.repositories.CarRepository;
import ru.bstu.itz212.fokin.lab5.utils.TablesConfigurer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties props = new Properties();
        Connection connection;

        try (InputStream input = new FileInputStream("config.properties");) {
            props.load(input);
            String host = props.getProperty("host");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            String url = String.format("%s?user=%s&password=%s", host, username, password);
            connection = DriverManager.getConnection(url);

            CarRepository carRepository = new CarRepository(connection);
            CarOwnerRepository carOwnerRepository = new CarOwnerRepository(connection);

            TablesConfigurer tc = new TablesConfigurer(connection);
            tc.createTablesIfNotExists();

            CarOwner carOwner = new CarOwner();
            carOwner.setGender(true);


            Car car = new Car();


            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
