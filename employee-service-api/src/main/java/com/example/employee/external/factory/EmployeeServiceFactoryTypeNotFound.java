package com.example.employee.external.factory;

public class EmployeeServiceFactoryTypeNotFound extends Throwable {
    private final String type;

    public EmployeeServiceFactoryTypeNotFound(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getMessage() {
        return String.format("EmployeeServiceFactory with this type %s is not found, parent error: %s",
                type, super.getMessage());
    }
}
