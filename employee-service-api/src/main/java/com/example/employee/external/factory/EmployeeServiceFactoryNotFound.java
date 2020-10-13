package com.example.employee.external.factory;

public class EmployeeServiceFactoryNotFound extends Throwable {
    private final String factoryType;

    public EmployeeServiceFactoryNotFound(String factoryType) {
        this.factoryType = factoryType;
    }

    public String getFactoryType() {
        return factoryType;
    }

    @Override
    public String getMessage() {
        return String.format("EmployeeServiceFactory with type '%s' not found, parent error: %s",
                factoryType, super.getMessage());
    }

}
