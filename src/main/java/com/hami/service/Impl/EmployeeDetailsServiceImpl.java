package com.hami.service.Impl;

import com.hami.model.EmployeeDetails;
import com.hami.repository.EmployeeDetailsRepository;
import com.hami.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired private EmployeeDetailsRepository employeeDetailsRepository;

    @Override
    public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails) {
        return employeeDetailsRepository.save(employeeDetails);
    }

    @Override
    public List<EmployeeDetails> getAllEmployeeDetails() {
        return employeeDetailsRepository.findAll();
    }

    @Override
    public Optional<EmployeeDetails> getEmployeeDetailsById(Long id) {
        return employeeDetailsRepository.findById(id);
    }

    @Override
    public void deleteEmployeeDetailsById(Long id) {
        employeeDetailsRepository.deleteById(id);
    }
}
