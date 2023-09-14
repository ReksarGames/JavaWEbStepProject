package ua.com.danit.dao;

import ua.com.danit.domain.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDao {
    void create(Country country);
    Country findById(String id) throws SQLException;
    void update(Country country);
    void delete(Country country);
    List<Country> findAll();
}
