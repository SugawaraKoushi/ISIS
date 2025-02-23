/**
 * CarHandler
 * <p>
 * version 1.0
 * <p>
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab5.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.bstu.itz212.fokin.lab5.models.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Обработчик xml-файла для сущности автомобиля
 */
public class CarHandler extends DefaultHandler {
    private static final String CARS = "cars";
    private static final String CAR = "car";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String COLOR = "color";
    private static final String LICENSE_PLATE = "licensePlate";
    private static final String OWNER = "owner";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String MIDDLE_NAME = "middleName";
    private static Properties props;

    private String element;
    private Car car = null;
    private List<Car> cars;

    static {
        props = new Properties();

        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void startDocument() throws SAXException {
        System.out.println(props.getProperty("startParseXML"));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;

        if (qName.equals(CAR)) {
            if (attributes.getLength() > 0) {
                car = new Car();
                int id = Integer.parseInt(attributes.getValue(0));
                car.setId(id);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (element) {
            case CARS:
                cars = new ArrayList<>();
                break;
            case CAR:
                if (car == null) {
                    car = new Car();
                }
                break;
            case BRAND:
                car.setBrand(new String(ch, start, length));
                break;
            case MODEL:
                car.setModel(new String(ch, start, length));
                break;
            case COLOR:
                car.setColor(new String(ch, start, length));
                break;
            case LICENSE_PLATE:
                car.setLicensePlate(new String(ch, start, length));
                break;
            case OWNER:
                break;
            case LAST_NAME:
                car.setOwnerLastName(new String(ch, start, length));
                break;
            case FIRST_NAME:
                car.setOwnerFirstName(new String(ch, start, length));
                break;
            case MIDDLE_NAME:
                car.setOwnerMiddleName(new String(ch, start, length));
                break;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(CAR)) {
            cars.add(car);
            car = null;
        }

        element = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(props.getProperty("endParseXML"));
    }

    public List<Car> getCars() {
        return cars;
    }
}
