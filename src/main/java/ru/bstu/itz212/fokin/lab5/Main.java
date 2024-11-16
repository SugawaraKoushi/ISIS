package ru.bstu.itz212.fokin.lab5;


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

            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
