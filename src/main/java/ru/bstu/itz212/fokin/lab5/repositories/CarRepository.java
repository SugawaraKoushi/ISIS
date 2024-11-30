package ru.bstu.itz212.fokin.lab5.repositories;

import ru.bstu.itz212.fokin.lab5.models.Car;
import ru.bstu.itz212.fokin.lab5.utils.CarSearchParams;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            rs.next();
            car = parseRow(rs);
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

    public List<Car> getByParams(CarSearchParams params) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM public.\"Cars\" WHERE");
        List<Car> cars = new ArrayList<>();

        if (params == null) {
            return cars;
        }

        if (params.getIds() != null && !params.getIds().isEmpty()) {
            String ids = params.getIds().stream().map(String::valueOf).collect(Collectors.joining(", "));
            sb.append(String.format("%n\"Id\" in (%s) AND", ids));
        }

        sb.append(getWhereParam(params.getBrands(), "Brand"));
        sb.append(getWhereParam(params.getModels(), "Model"));
        sb.append(getWhereParam(params.getColors(), "Color"));
        sb.append(getWhereParam(params.getLicensePlates(), "LicensePlate"));
        sb.append(getWhereParam(params.getOwnersLastNames(), "OwnerLastName"));
        sb.append(getWhereParam(params.getOwnersFirstNames(), "OwnerFirstName"));
        sb.append(getWhereParam(params.getOwnersMiddleNames(), "OwnerMiddleName"));

        sb.delete(sb.toString().length() - 4, sb.toString().length());
        String query = sb.toString();

        try (Statement statement = super.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Car car = parseRow(rs);
                cars.add(car);
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }

    public List<Car> getAll() {
        String query = "SELECT * FROM public.\"Cars\"";
        List<Car> cars = new ArrayList<>();

        try (Statement statement = super.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Car car = parseRow(rs);
                cars.add(car);
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }

    private Car parseRow(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("Id"));
        car.setBrand(rs.getString("Brand"));
        car.setModel(rs.getString("Model"));
        car.setColor(rs.getString("Color"));
        car.setLicensePlate(rs.getString("LicensePlate"));
        car.setOwnerLastName(rs.getString("OwnerLastName"));
        car.setOwnerFirstName(rs.getString("OwnerFirstName"));
        car.setOwnerMiddleName(rs.getString("OwnerMiddleName"));
        return car;
    }

    private String getWhereParam(List<String> param, String paramName) {
        if (param != null && !param.isEmpty()) {
            String params = param.stream()
                    .map(String::valueOf).collect(Collectors.joining("', '"));
            return String.format("%n\"%s\" in ('%s') AND", paramName, params);
        }

        return "";
    }
}
