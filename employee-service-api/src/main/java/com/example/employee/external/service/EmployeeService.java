package com.example.employee.external.service;

import com.example.employee.external.model.EmployeeData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    Optional<EmployeeData> getEmployeeWithUUID(UUID employeeId);

    List<EmployeeData> getAllEmployees();

}
