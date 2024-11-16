package ru.bstu.itz212.fokin.lab5.repositories;

import ru.bstu.itz212.fokin.lab5.models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarRepository extends CrudRepository<Car>{
    public CarRepository(Connection connection) {
        super(connection);
    }

    @Override
    public int create(Car car) {
        String query = """
                INSERT INTO public."Cars"("Brand", "Model", "Color", "LicensePlate", "OwnerId")
                VALUES (%d, %s, %s, %s, %s, %d);
                """;

        try (Statement statement = super.getConnection().createStatement()) {
            statement.execute(String.format(query,
                    car.getId(), car.getBrand(), car.getModel(),
                    car.getColor(), car.getLicensePlate(), car.getOwnerId())
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return car.getId();
    }

    @Override
    public Car get(int id) {
        String query = """
                SELECT * FROM public."Cars"
                WHERE "Id" = %d
                """;
        Car car;

        try (Statement statement = super.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(String.format(query, id));
            car = new Car();
            car.setId(rs.getInt("Id"));
            car.setBrand(rs.getString("Brand"));
            car.setModel(rs.getString("Model"));
            car.setColor(rs.getString("Color"));
            car.setLicensePlate(rs.getString("LicensePlate"));
            car.setOwnerId(rs.getInt("OwnerId"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return car;
    }

    @Override
    public int update(Car car) {
        String query = """
                UPDATE public."Cars"
                SET "Brand"=%s, "Model"=%s, "Color"=%s, "LicensePlate"=%s, "OwnerId"=%d
                WHERE Id=%d;
                """;

        try (Statement statement = super.getConnection().createStatement()) {
            statement.execute(String.format(query,
                    car.getBrand(), car.getModel(), car.getColor(),
                    car.getLicensePlate(), car.getOwnerId(), car.getId())
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return car.getId();
    }

    @Override
    public int delete(int id) {
        String query = """
                DELETE FROM public."Cars"
                WHERE Id=%d;
                """;

        try (Statement statement = super.getConnection().createStatement()) {
            statement.execute(String.format(query, id));
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return id;
    }
}
