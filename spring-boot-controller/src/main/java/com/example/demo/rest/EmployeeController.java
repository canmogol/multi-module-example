package com.example.demo.rest;

import com.example.employee.external.model.EmployeeData;
import com.example.employee.external.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
class EmployeeController {

    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> all() {
        return service.getAllEmployees()
                .stream()
                .map(this::createEmployeeDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") UUID id) {
        return service.getEmployeeWithUUID(id)
                .map(this::createEmployeeDTO)
                .orElse(new EmployeeDTO());
    }

    private EmployeeDTO createEmployeeDTO(EmployeeData e) {
        return new EmployeeDTO(e.getId(), e.getName(), e.getRetired());
    }

}
