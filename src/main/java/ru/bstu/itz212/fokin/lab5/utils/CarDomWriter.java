/**
 * CarDomWriter
 *
 * version 1.0
 *
 * (с) Фокин Владислав
 */

package ru.bstu.itz212.fokin.lab5.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import ru.bstu.itz212.fokin.lab5.models.Car;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Класс для записи сущности автомобиля в xml-файл
 */
public class CarDomWriter {
    private List<Car> cars;

    public CarDomWriter(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * Запись автомобилей {@code cars} в файл
     * @param path путь к файлу записи
     */
    public void writeToFile(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("cars");
            document.appendChild(root);

            for (Car car : cars) {
                root.appendChild(getCar(document, car));
            }

            document.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);
            StreamResult file = new StreamResult(new File(path));
            transformer.transform(source, file);
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private static Node getCar(Document document, Car car) {
        Element carElement = document.createElement("car");
        carElement.setAttribute("id", String.valueOf(car.getId()));
        Element brand = document.createElement("brand");
        brand.setTextContent(car.getBrand());
        Element model = document.createElement("model");
        model.setTextContent(car.getModel());
        Element color = document.createElement("color");
        color.setTextContent(car.getColor());
        Element licensePlate = document.createElement("licensePlate");
        licensePlate.setTextContent(car.getLicensePlate());
        Node owner = getOwner(document, car);
        carElement.appendChild(brand);
        carElement.appendChild(model);
        carElement.appendChild(color);
        carElement.appendChild(licensePlate);
        carElement.appendChild(owner);
        return carElement;
    }

    private static Node getOwner(Document document, Car car) {
        Element owner = document.createElement("owner");
        Element lastName = document.createElement("lastName");
        lastName.setTextContent(car.getOwnerLastName());
        Element firstName = document.createElement("firstName");
        firstName.setTextContent(car.getOwnerFirstName());
        Element middleName = document.createElement("middleName");
        middleName.setTextContent(car.getOwnerMiddleName());
        owner.appendChild(lastName);
        owner.appendChild(firstName);
        owner.appendChild(middleName);
        return owner;
    }
}
