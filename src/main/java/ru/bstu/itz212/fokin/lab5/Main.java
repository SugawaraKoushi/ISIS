package ru.bstu.itz212.fokin.lab5;

import org.xml.sax.SAXException;
import ru.bstu.itz212.fokin.lab5.models.Car;
import ru.bstu.itz212.fokin.lab5.repositories.CarRepository;
import ru.bstu.itz212.fokin.lab5.utils.TablesConfigure;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
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
            TablesConfigure tc = new TablesConfigure(connection);
            tc.createTablesIfNotExists();

//            Car car = new Car();
//            car.setBrand("Toyota");
//            car.setModel("Camry");
//            car.setColor("Black");
//            car.setLicensePlate("А757КЕ51");
//            car.setOwnerLastName("Иванов");
//            car.setOwnerFirstName("Иван");
//            car.setOwnerMiddleName("Иванович");
//            car = carRepository.create(car);
//
//            car.setModel("Lada");
//            carRepository.update(car);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            CarHandler carHandler = new CarHandler();
            URL carsXMl = Main.class.getResource("/Cars.xml");
            parser.parse(carsXMl.getFile(), carHandler);

            List<Car> cars = carHandler.getCars();

            CarDomWriter writer = new CarDomWriter(cars);
            writer.writeToFile("./Cars_new.xml");

//            for(Car car : cars) {
//                carRepository.create(car);
//            }

            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
