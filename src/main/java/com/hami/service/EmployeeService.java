package com.hami.service;

import com.hami.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public void deleteEmployee(Long id);
}
