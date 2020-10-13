package com.example.employee.internal.service;

import com.example.employee.external.model.EmployeeData;
import com.example.employee.external.service.EmployeeService;
import com.example.employee.external.service.EmployeeServiceError;
import com.example.employee.internal.repository.Employee;
import com.example.employee.internal.repository.EmployeeJDBCError;
import com.example.employee.internal.repository.JDBCEmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class JDBCEmployeeService implements EmployeeService {

    private final JDBCEmployeeRepository repository;

    public JDBCEmployeeService(String connectionURL) {
        this.repository = new JDBCEmployeeRepository(connectionURL);
    }

    @Override
    public Optional<EmployeeData> getEmployeeWithUUID(UUID employeeId) {
        try {
            return repository.findOne(employeeId)
                    .map(this::createEmployee);
        } catch (EmployeeJDBCError e) {
            String error = String.format("Exception while finding Employee with id %s, error: %s",
                    employeeId, e.getMessage());
            throw new EmployeeServiceError(error);
        }
    }

    @Override
    public List<EmployeeData> getAllEmployees() {
        try {
            return repository.findAll().stream()
                    .map(this::createEmployee)
                    .collect(Collectors.toList());
        } catch (EmployeeJDBCError e) {
            String error = String.format("Exception while finding all Employees, error: %s", e.getMessage());
            throw new EmployeeServiceError(error);
        }
    }

    private EmployeeData createEmployee(Employee employee) {
        return new EmployeeData(employee.getId(), employee.getName(), employee.getRetired());
    }

}
