package ua.com.danit.service;

import ua.com.danit.domain.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {
    void create(Country country);
    Country findById(String id) throws SQLException;
    void update(Country country);
    void delete(Country country);
    List<Country> findAll();
}
