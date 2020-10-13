package com.example.employee.external.service;

public enum EmployeeServiceType {

    JDBC, NO_OP, IN_MEMORY;

    public static EmployeeServiceType get(String type) throws EmployeeServiceTypeNotFound {
        for (EmployeeServiceType employeeServiceType : EmployeeServiceType.values()) {
            if (employeeServiceType.name().equalsIgnoreCase(type)) {
                return employeeServiceType;
            }
        }
        throw new EmployeeServiceTypeNotFound(type);
    }

}
