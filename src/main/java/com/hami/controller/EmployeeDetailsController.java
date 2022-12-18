package com.hami.controller;

import com.hami.exception.ResourceNotFoundException;
import com.hami.model.EmployeeDetails;
import com.hami.service.Impl.EmployeeDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employeeDetail")
public class EmployeeDetailsController {

    @Autowired private EmployeeDetailsServiceImpl employeeDetailsService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDetails> addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        EmployeeDetails newEmployeeDetail = employeeDetailsService.addEmployeeDetails(employeeDetails);
        return new ResponseEntity<EmployeeDetails>(newEmployeeDetail, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDetails>> getAllEmployeeDetails() {
        return ResponseEntity.ok(employeeDetailsService.getAllEmployeeDetails());
    }

    @GetMapping("/getEmployeeDetail/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetailById(@PathVariable("id") Long id) {
        EmployeeDetails employeeDetails = employeeDetailsService.getEmployeeDetailsById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee detail not  found")
        );
        return ResponseEntity.ok().body(employeeDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDetails> deleteEmployeeDetailById(@PathVariable("id") Long id) {
        employeeDetailsService.deleteEmployeeDetailsById(id);
        return new ResponseEntity<EmployeeDetails>(HttpStatus.OK);
    }

}
