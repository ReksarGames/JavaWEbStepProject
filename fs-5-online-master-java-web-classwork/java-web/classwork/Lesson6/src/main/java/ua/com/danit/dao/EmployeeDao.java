package ua.com.danit.dao;

import ua.com.danit.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
}
