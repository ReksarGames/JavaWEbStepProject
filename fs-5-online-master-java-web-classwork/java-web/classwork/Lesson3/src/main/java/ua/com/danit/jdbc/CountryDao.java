package ua.com.danit.jdbc;

import java.util.List;

public interface CountryDao {
    void create(Country country);
    Country findById(String id);
    void update(Country country);
    void delete(Country country);
    List<Country> findAll();
}
