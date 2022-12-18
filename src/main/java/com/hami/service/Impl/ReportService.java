package com.hami.service.Impl;

import com.hami.model.Employee;
import com.hami.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired private EmployeeRepository employeeRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        List<Employee> employees = employeeRepository.findAll();

        File file = ResourceUtils.getFile("classpath:Employee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Hamed Zarrabi");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:/HamedProject/DemoReportForISE/Reports" + "/employee.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/HamedProject/DemoReportForISE/Reports" + "/employee.pdf");
        }

        return "report export in your path";
    }
}
