package ru.bstu.itz212.fokin.lab5.repositories;

import ru.bstu.itz212.fokin.lab5.models.Car;

import java.sql.*;

public class CarRepository extends CrudRepository<Car> {
    public CarRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Car create(Car car) {
        String query;

        if (car.getId() > 0) {
            query = String.format("""
                INSERT INTO public."Cars"("Id", "Brand", "Model", "Color", "LicensePlate",
                    "OwnerLastName", "OwnerFirstName", "OwnerMiddleName")
                VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s');
                """, car.getId(), car.getBrand(), car.getModel(), car.getColor(),
                    car.getLicensePlate(), car.getOwnerLastName(),
                    car.getOwnerFirstName(), car.getOwnerMiddleName());
        } else {
            query = String.format("""
                INSERT INTO public."Cars"("Brand", "Model", "Color", "LicensePlate",
                    "OwnerLastName", "OwnerFirstName", "OwnerMiddleName")
                VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');
                """, car.getBrand(), car.getModel(), car.getColor(),
                    car.getLicensePlate(), car.getOwnerLastName(),
                    car.getOwnerFirstName(), car.getOwnerMiddleName());
        }

        try (PreparedStatement statement = super
                .getConnection()
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                car.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
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
            car.setOwnerLastName(rs.getString("OwnerLastName"));
            car.setOwnerFirstName(rs.getString("OwnerFirstName"));
            car.setOwnerMiddleName(rs.getString("OwnerMiddleName"));
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return car;
    }

    @Override
    public void update(Car car) {
        String query = """
                UPDATE public."Cars"
                SET "Brand"='%s', "Model"='%s', "Color"='%s', "LicensePlate"='%s',
                    "OwnerLastName"='%s', "OwnerFirstName"='%s', "OwnerMiddleName"='%s'
                WHERE "Id"=%d;
                """;

        try (Statement statement = super.getConnection().createStatement()) {
            statement.execute(String.format(query,
                    car.getBrand(), car.getModel(), car.getColor(),
                    car.getLicensePlate(), car.getOwnerLastName(),
                    car.getOwnerFirstName(), car.getOwnerMiddleName(), car.getId())
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = """
                DELETE FROM public."Cars"
                WHERE "Id"=%d;
                """;

        try (Statement statement = super.getConnection().createStatement()) {
            statement.execute(String.format(query, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
