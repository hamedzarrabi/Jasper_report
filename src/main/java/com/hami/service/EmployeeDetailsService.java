package com.hami.service;

import com.hami.model.EmployeeDetails;

import java.util.List;
import java.util.Optional;

public interface EmployeeDetailsService {
    public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails);
    public List<EmployeeDetails> getAllEmployeeDetails();
    public Optional<EmployeeDetails> getEmployeeDetailsById(Long id);
    public void deleteEmployeeDetailsById(Long id);
}
