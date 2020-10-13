package com.example.employee.external.service;

public class EmployeeServiceError extends RuntimeException {
    private final String error;

    public EmployeeServiceError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return String.format("%s, parent error: %s", error, super.getMessage());
    }

}
