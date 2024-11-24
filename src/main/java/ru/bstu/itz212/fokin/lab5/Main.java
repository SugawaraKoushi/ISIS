package ru.bstu.itz212.fokin.lab5;

import org.xml.sax.SAXException;
import ru.bstu.itz212.fokin.lab5.models.Car;
import ru.bstu.itz212.fokin.lab5.repositories.CarRepository;
import ru.bstu.itz212.fokin.lab5.utils.CarDomWriter;
import ru.bstu.itz212.fokin.lab5.utils.CarHandler;
import ru.bstu.itz212.fokin.lab5.utils.TablesConfigure;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        Connection connection;

        try {
            connection = setConnection();
            CarRepository carRepository = new CarRepository(connection);
            TablesConfigure tc = new TablesConfigure(connection);
            tc.createTablesIfNotExists();
            Scanner scanner = new Scanner(System.in);
            int actionType = chooseAction(scanner);

            if (actionType == 1) {  // Ввод данных
                int formatType = chooseFormatType(scanner);
                int operationType = chooseOperationType(scanner);

                if (formatType == 1) {  // БД

                } else {    // xml
                    System.out.println("Создайте файл и назовите его \"Cars.xml\"");
                    String importFolderPath = props.getProperty("importFolder");
                    File file = new File(importFolderPath + "Cars.xml");
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();
                    CarHandler handler = new CarHandler();
                    parser.parse(file, handler);
                    List<Car> cars = handler.getCars();
                }

            } else {    // Вывод данных в xml
                List<Car> cars = carRepository.getAll();
                CarDomWriter writer = new CarDomWriter(cars);
                String exportFolderPath = props.getProperty("exportFolder");
                writer.writeToFile(exportFolderPath + "Car_export.xml");
            }





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

//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser parser = factory.newSAXParser();
//            CarHandler carHandler = new CarHandler();
//            URL carsXMl = Main.class.getResource("/Cars.xml");
//            parser.parse(carsXMl.getFile(), carHandler);
//
//            List<Car> cars = carHandler.getCars();
//
//            CarDomWriter writer = new CarDomWriter(cars);
//            writer.writeToFile("./Cars_new.xml");
//
//            for(Car car : cars) {
//                carRepository.create(car);
//            }
//
//            CarSearchParams params = new CarSearchParams();
//            Integer[] ids = new Integer[] {1, 2};
//            params.setIds(Arrays.asList(ids));
//            String[] brands = new String[] {"Toyota", "BMW"};
//            params.setBrands(Arrays.asList(brands));
//            cars = carRepository.getCars(params);

//            Car car = new Car();
//            Scanner scanner = new Scanner(System.in);
//            car.init(scanner);
//            car = carRepository.create(car);

            connection.close();
        } catch (SQLException | ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection setConnection() throws SQLException {
        Properties props = new Properties();
        Connection connection = null;

        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            String host = props.getProperty("host");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            String url = String.format("%s?user=%s&password=%s", host, username, password);
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static int chooseAction(Scanner scanner) {
        int actionType;

        do {
            System.out.println("""
                        Выберите действие:
                        1. Ввод данных;
                        2. Вывод данных;
                        """);
            actionType = scanner.nextInt();
        } while (actionType < 1 || actionType > 2);

        return actionType;
    }

    private static int chooseFormatType(Scanner scanner) {
        int formatType;

        do {
            System.out.println("""
                        Выберите формат представления данных:
                        1. БД;
                        2. xml;
                        """);
            formatType = scanner.nextInt();
        } while (formatType < 1 || formatType > 2);

        return formatType;
    }

    private static int chooseOperationType(Scanner scanner) {
        int operationType = 0;

        do {
            System.out.println("""
                        Выберите операцию:
                        1. Добавление
                        2. Редактирование
                        3. Удаление
                        """);
            operationType = scanner.nextInt();
        } while (operationType < 1 || operationType > 3);

        return operationType;
    }
}
