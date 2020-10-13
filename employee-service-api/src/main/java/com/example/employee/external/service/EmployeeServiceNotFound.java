package com.example.employee.external.service;

public class EmployeeServiceNotFound extends Exception {
    private final String serviceType;
    private final String connectionURL;

    public EmployeeServiceNotFound(String serviceType, String connectionURL) {
        this.serviceType = serviceType;
        this.connectionURL = connectionURL;
    }

    @Override
    public String getMessage() {
        return String.format("EmployeeService with type '%s' not found for connection URL %s, parent error: %s",
                connectionURL, serviceType, super.getMessage());
    }

}
