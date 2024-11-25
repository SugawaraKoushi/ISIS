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
            connection = setConnection(props);
            CarRepository carRepository = new CarRepository(connection);
            TablesConfigure tc = new TablesConfigure(connection);
            tc.createTablesIfNotExists();
            Scanner scanner = new Scanner(System.in);
            int actionType = getAction(scanner);

            if (actionType == 1) {  // Ввод данных
                int formatType = getFormatType(scanner);
                int operationType = getOperationType(scanner);

                if (formatType == 1) {  // БД
                    switch (operationType) {
                        case 1: {
                            int optionType = getCarsByOption(scanner);
                            break;
                        }
                        case 2: {
                            Car car = new Car();
                            car.init(scanner);
                            car = carRepository.create(car);
                            System.out.println(car);
                        }
                        case 3: {
                            System.out.print("Введите id автомобиля: ");
                            int id = scanner.nextInt();
                            Car car = carRepository.get(id);
                            boolean stop = false;

                            do {
                                int field = getCarFieldToChange(scanner);
                                switch (field) {
                                    case 1:
                                        car.setBrand(scanner.nextLine());
                                        break;
                                    case 2:
                                        car.setModel(scanner.nextLine());
                                        break;
                                    case 3:
                                        car.setColor(scanner.nextLine());
                                        break;
                                    case 4:
                                        car.setLicensePlate(scanner.nextLine());
                                        break;
                                    case 5:
                                        car.setOwnerLastName(scanner.nextLine());
                                        break;
                                    case 6:
                                        car.setOwnerFirstName(scanner.nextLine());
                                        break;
                                    case 7:
                                        car.setOwnerMiddleName(scanner.nextLine());
                                        break;
                                    case 0:
                                        stop = true;
                                }
                            } while (!stop);
                        }


                    }
                } else {    // xml
                    System.out.println("Создайте файл и назовите его \"Cars.xml\"");
                    System.out.println("Нажмите любую клавишу для продолжения...");
                    scanner.next();
                    // ожидание пока пользователь нажмет что-то
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

    private static Connection setConnection(Properties props) throws SQLException {
        props = new Properties();
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

    private static int getAction(Scanner scanner) {
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

    private static int getFormatType(Scanner scanner) {
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

    private static int getOperationType(Scanner scanner) {
        int operationType = 0;

        do {
            System.out.println("""
                        Выберите операцию:
                        1. Просмотр данных
                        2. Добавление
                        3. Редактирование
                        4. Удаление
                        """);
            operationType = scanner.nextInt();
        } while (operationType < 1 || operationType > 4);

        return operationType;
    }

    private static int getCarsByOption(Scanner scanner) {
        int optionType = 0;

        do {
            System.out.println("""
                        Выберите опцию:
                        1. Все данные
                        2. По критериям
                        """);
            optionType = scanner.nextInt();
        } while (optionType < 1 || optionType > 2);

        return optionType;
    }

    private static int getCarFieldToChange(Scanner scanner) {
        int operationType = 0;

        do {
            System.out.println("""
                        Выберите поле:
                        1. Бренд
                        2. Модель
                        3. Цвет
                        4. Регистрационный номер
                        5. Фамилия владельца
                        6. Имя владельца
                        7. Отчество владельца
                        0. Выход
                        """);
            operationType = scanner.nextInt();
        } while (operationType < 0 || operationType > 7);

        return operationType;
    }
}
