package ua.com.danit.service;

import ua.com.danit.dao.CountryDao;
import ua.com.danit.domain.Country;

import java.sql.SQLException;
import java.util.List;

public class DefaultCountryService implements CountryService{
    private CountryDao countryDao;
    public DefaultCountryService(CountryDao countryDao){
        this.countryDao = countryDao;
    }
    @Override
    public void create(Country country) {
        countryDao.create(country);
    }

    @Override
    public Country findById(String id) throws SQLException {
        return countryDao.findById(id);
    }

    @Override
    public void update(Country country) {
        countryDao.update(country);
    }

    @Override
    public void delete(Country country) {
        countryDao.delete(country);
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }
}
