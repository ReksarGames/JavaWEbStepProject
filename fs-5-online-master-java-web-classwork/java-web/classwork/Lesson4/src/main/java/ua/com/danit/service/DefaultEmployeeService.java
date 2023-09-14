package ua.com.danit.service;

import ua.com.danit.dao.EmployeeDao;
import ua.com.danit.domain.Employee;

import java.util.List;
import java.util.Optional;

public class DefaultEmployeeService implements EmployeeService{
    private final EmployeeDao employeeDao;

    public DefaultEmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.empty();
    }
}
