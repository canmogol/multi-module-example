package com.example.employee.internal.service;

import com.example.employee.external.model.EmployeeData;
import com.example.employee.external.service.EmployeeService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NoOpEmployeeService implements EmployeeService {

    @Override
    public Optional<EmployeeData> getEmployeeWithUUID(UUID employeeId) {
        return Optional.empty();
    }

    @Override
    public List<EmployeeData> getAllEmployees() {
        return Collections.emptyList();
    }

}
