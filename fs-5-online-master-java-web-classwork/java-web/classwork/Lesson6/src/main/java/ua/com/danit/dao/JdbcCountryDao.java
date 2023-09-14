package ua.com.danit.dao;

import ua.com.danit.dao.CountryDao;
import ua.com.danit.domain.Country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCountryDao implements CountryDao {
    @Override
    public void create(Country country) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO countries(country_id, country_name, region_id) VALUES ('" + country.getCountryId() + "', '" + country.getCountryName() + "', " + country.getRegionId() + ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Country findById(String id) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.countries\n" +
                    "WHERE country_id = '" + id + "'");
            resultSet.next();
            String countryId = resultSet.getString("country_id");
            String countryName = resultSet.getString("country_name");
            long countryRegion = resultSet.getLong("region_id");

            return new Country(countryId, countryName, countryRegion);
        }
    }

    @Override
    public void update(Country country) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE countries SET country_id = '" + country.getCountryId() + "', country_name = '" + country.getCountryName() + "', region_id = " + country.getRegionId() +
                    "WHERE country_id = '" + country.getCountryId() + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Country country) {

    }

    @Override
    public List<Country> findAll() {
        List<Country> allCountries = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM countries");

            while (resultSet.next()) {

                String countryId = resultSet.getString("country_id");
                String countryName = resultSet.getString("country_name");
                long countryRegion = resultSet.getLong("region_id");

                allCountries.add(new Country(countryId, countryName, countryRegion));

            }

        } catch (SQLException e){
            System.out.println("Something went wrong, with db interaction returning countries");
            e.printStackTrace();
        }

        return allCountries;
    }
}