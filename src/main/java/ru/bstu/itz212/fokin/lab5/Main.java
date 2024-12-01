package ru.bstu.itz212.fokin.lab5;

import org.xml.sax.SAXException;
import ru.bstu.itz212.fokin.lab5.models.Car;
import ru.bstu.itz212.fokin.lab5.repositories.CarRepository;
import ru.bstu.itz212.fokin.lab5.utils.CarDomWriter;
import ru.bstu.itz212.fokin.lab5.utils.CarHandler;
import ru.bstu.itz212.fokin.lab5.utils.CarSearchParams;
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
    private static final String TABLE_HEADER =
            String.format("%-5s|%20s|%20s|%20s|%20s|%40s", "#", "Бренд", "Модель", "Цвет", "Рег. номер", "ФИО владельца");

    public static void main(String[] args) {
        Properties props = getProperties();
        Connection connection;

        try {
            connection = setConnection(props);
            CarRepository carRepository = new CarRepository(connection);
            TablesConfigure tc = new TablesConfigure(connection);
            tc.createTablesIfNotExists();
            Scanner scanner = new Scanner(System.in);
            int formatType = getFormatType(scanner);
            int operationType = getOperationType(scanner);

            switch (operationType) {
                case 1: {   // Просмотр и поиск
                    int optionType = getOption(scanner);
                    List<Car> cars;

                    if (optionType == 1) {  // Все записи
                        cars = carRepository.getAll();
                    } else {    // Выборка по полям
                        cars = getCarsBySearchParams(scanner, carRepository);
                    }

                    if (formatType == 1) {
                        System.out.println(TABLE_HEADER);
                        cars.forEach(System.out::println);
                    } else {
                        CarDomWriter writer = new CarDomWriter(cars);
                        String path = props.getProperty("exportFolder") + "Cars_export.xml";
                        writer.writeToFile(path);
                    }

                    break;
                }
                case 2: {   // Добавление
                    List<Car> cars;

                    if (formatType == 1) {
                        cars = createCarsFromManualInput(scanner);
                    } else {
                        cars = getCarsFromXml(props);
                    }

                    cars.forEach(carRepository::create);
                    break;
                }
                case 3: {   // Редактирование
                    List<Car> cars;

                    if (formatType == 1) {
                        cars = getCarToUpdate(scanner, carRepository);
                    } else {
                        cars = getCarsFromXml(props);
                    }

                    cars.forEach(carRepository::update);
                    break;
                }
                case 4: {   // Удаление
                    List<Car> cars;

                    if (formatType == 1) {
                        cars = getCarsToDelete(scanner, carRepository);
                    } else {
                        cars = getCarsFromXml(props);
                    }

                    cars.forEach(carRepository::delete);
                    break;
                }
            }

            connection.close();
        } catch (SQLException | ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() {
        Properties props = new Properties();

        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }

    private static Connection setConnection(Properties props) throws SQLException {
        String host = props.getProperty("host");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        String url = String.format("%s?user=%s&password=%s", host, username, password);
        return DriverManager.getConnection(url);
    }

    private static int getAction(Scanner scanner) {
        int actionType;

        do {
            System.out.print("""
                    Выберите действие:
                    1. Ввод данных
                    2. Вывод данных
                    """);
            actionType = scanner.nextInt();
        } while (actionType < 1 || actionType > 2);

        return actionType;
    }

    private static int getFormatType(Scanner scanner) {
        int formatType;

        do {
            System.out.print("""
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
            System.out.print("""
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

    private static int getOption(Scanner scanner) {
        int optionType = 0;

        do {
            System.out.print("""
                    Выберите опцию:
                    1. Все данные
                    2. По критериям
                    """);
            optionType = scanner.nextInt();
        } while (optionType < 1 || optionType > 2);

        return optionType;
    }

    private static int getCarFieldToChange(Scanner scanner) {
        int field;

        do {
            System.out.print("""
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
            field = scanner.nextInt();
        } while (field < 0 || field > 7);

        scanner.nextLine();
        return field;
    }

    private static List<Car> getCarsBySearchParams(Scanner scanner, CarRepository carRepository) {
        List<Integer> ids = new ArrayList<>();
        List<String> brands = new ArrayList<>();
        List<String> models = new ArrayList<>();
        List<String> colors = new ArrayList<>();
        List<String> licensePlates = new ArrayList<>();
        List<String> ownersLastNames = new ArrayList<>();
        List<String> ownersFirstNames = new ArrayList<>();
        List<String> ownersMiddleNames = new ArrayList<>();

        int field;
        boolean stop = false;

        do {
            do {
                System.out.print("""
                        Выберите поле:
                        1. id
                        2. Бренд
                        3. Модель
                        4. Цвет
                        5. Регистрационный номер
                        6. Фамилия владельца
                        7. Имя владельца
                        8. Отчество владельца
                        0. Выход
                        """);
                field = scanner.nextInt();
                scanner.nextLine();
            } while (field < 0 || field > 8);


            switch (field) {
                case 1:
                    ids.add(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 2:
                    brands.add(scanner.nextLine());
                    break;
                case 3:
                    models.add(scanner.nextLine());
                    break;
                case 4:
                    colors.add(scanner.nextLine());
                    break;
                case 5:
                    licensePlates.add(scanner.nextLine());
                    break;
                case 6:
                    ownersLastNames.add(scanner.nextLine());
                    break;
                case 7:
                    ownersFirstNames.add(scanner.nextLine());
                    break;
                case 8:
                    ownersMiddleNames.add(scanner.nextLine());
                    break;
                case 0:
                    stop = true;
            }
        } while (!stop);

        CarSearchParams params = new CarSearchParams(ids, brands, models, colors, licensePlates,
                ownersLastNames, ownersFirstNames, ownersMiddleNames);

        return carRepository.getByParams(params);
    }

    private static List<Car> createCarsFromManualInput(Scanner scanner) {
        List<Car> cars = new ArrayList<>();
        boolean stop = false;

        do {
            System.out.print("""
                    1. Добавить запись
                    0. Выход
                    """);
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 1) {
                Car car = new Car();
                car.init(scanner);
                cars.add(car);
            } else if (input == 0) {
                stop = true;
            }

        } while (!stop);

        return cars;
    }

    private static List<Car> getCarsFromXml(Properties props)
            throws ParserConfigurationException, SAXException, IOException {
        System.out.println("Создайте файл и назовите его \"Cars.xml\"");
        System.out.println("Нажмите ENTER для продолжения...");
        System.in.read();
        String importFolderPath = props.getProperty("importFolder");
        File file = new File(importFolderPath + "Cars.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        CarHandler handler = new CarHandler();
        parser.parse(file, handler);
        return handler.getCars();
    }

    private static List<Car> getCarToUpdate(Scanner scanner, CarRepository carRepository) {
        System.out.print("Введите идентификатор автомобиля для редактирования: ");
        int id = scanner.nextInt();
        Car car = carRepository.get(id);
        System.out.println(TABLE_HEADER);
        System.out.println(car);
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

            System.out.println(TABLE_HEADER);
            System.out.println(car);
        } while (!stop);

        return List.of(car);
    }

    private static List<Car> getCarsToDelete(Scanner scanner, CarRepository carRepository) {
        System.out.println("Выберите автомобиль для удаления:");
        return getCarsBySearchParams(scanner, carRepository);
    }
}
