package ru.bstu.itz212.fokin.lab5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.bstu.itz212.fokin.lab5.models.Car;

import java.util.ArrayList;
import java.util.List;

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

    private String element;
    private Car car = null;
    private List<Car> cars;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки данных из XML-файла");
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
        System.out.println("Обработка XML-файла закончена");
    }

    public List<Car> getCars() {
        return cars;
    }
}
