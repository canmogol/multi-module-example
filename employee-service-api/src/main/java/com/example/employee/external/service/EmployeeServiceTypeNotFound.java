package com.example.employee.external.service;

public class EmployeeServiceTypeNotFound extends Exception {
    private final String type;

    public EmployeeServiceTypeNotFound(String type) {
        this.type = type;
    }

    public String getServiceType() {
        return type;
    }

    @Override
    public String getMessage() {
        return String.format("EmployeeServiceType with type '%s' not found, parent error: %s",
                type, super.getMessage());
    }
}
