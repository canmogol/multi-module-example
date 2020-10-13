package com.example.employee.internal.service;

import com.example.employee.external.model.EmployeeData;
import com.example.employee.external.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryEmployeeService implements EmployeeService {

    private static final Map<UUID, EmployeeData> employees =
            new HashMap<UUID, EmployeeData>() {{
                UUID uuid = UUID.fromString("6BA3F5F7-6368-4156-B764-BA07C630DAD5");
                EmployeeData employeeData = new EmployeeData(uuid, "Sponge Bob", false);
                put(uuid, employeeData);
            }};


    @Override
    public Optional<EmployeeData> getEmployeeWithUUID(UUID employeeId) {
        return Optional.ofNullable(employees.get(employeeId));
    }

    @Override
    public List<EmployeeData> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

}
