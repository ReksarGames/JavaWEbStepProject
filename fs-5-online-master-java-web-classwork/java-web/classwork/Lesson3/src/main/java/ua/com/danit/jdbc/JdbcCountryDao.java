package ua.com.danit.jdbc;

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

    }

    @Override
    public Country findById(String id) {
        return null;
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void delete(Country country) {

    }

    @Override
    public List<Country> findAll() {

        return null;
    }
}
