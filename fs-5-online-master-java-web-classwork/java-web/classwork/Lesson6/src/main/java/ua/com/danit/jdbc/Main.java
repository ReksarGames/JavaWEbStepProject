package ua.com.danit.jdbc;

import ua.com.danit.dao.JdbcCountryDao;
import ua.com.danit.domain.Country;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        JdbcCountryDao countryDao = new JdbcCountryDao();

        countryDao.update(new Country("UA", "Ukraine", 1L));
//        countryDao.update(new Country("UA", "Great Ukraine", 1L));

        List<Country> countries = countryDao.findAll();
        countries.forEach(System.out::println);
    }
}
