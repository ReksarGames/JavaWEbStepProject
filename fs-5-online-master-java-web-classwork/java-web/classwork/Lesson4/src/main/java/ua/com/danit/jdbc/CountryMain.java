package ua.com.danit.jdbc;

import ua.com.danit.dao.CountryDao;
import ua.com.danit.dao.JdbcCountryDao;

import java.sql.SQLException;

public class CountryMain {
    public static void main(String[] args) throws SQLException {
        CountryDao countryDao = new JdbcCountryDao();

        System.out.println(countryDao.findById("UK"));
        System.out.println(countryDao.findById("US"));

        countryDao.findAll().forEach(System.out::println);

    }
}