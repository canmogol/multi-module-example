package com.example.employee.external.factory;

public enum EmployeeServiceFactoryType {

    DEFAULT;

    public static EmployeeServiceFactoryType get(String type) throws EmployeeServiceFactoryTypeNotFound {
        for (EmployeeServiceFactoryType employeeServiceFactoryType : EmployeeServiceFactoryType.values()) {
            if (employeeServiceFactoryType.name().equalsIgnoreCase(type)) {
                return employeeServiceFactoryType;
            }
        }
        throw new EmployeeServiceFactoryTypeNotFound(type);
    }

}
