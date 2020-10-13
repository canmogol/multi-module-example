package com.example.employee.external.factory;


import com.example.employee.external.service.EmployeeService;
import com.example.employee.external.service.EmployeeServiceNotFound;
import com.example.employee.external.service.EmployeeServiceTypeNotFound;

import java.util.ServiceLoader;

public interface EmployeeServiceFactory {

    EmployeeServiceFactoryType getType();

    EmployeeService getEmployeeService(String serviceType, String connectionURL)
            throws EmployeeServiceTypeNotFound, EmployeeServiceNotFound;

    static EmployeeServiceFactory getEmployeeServiceFactory(String factoryType)
            throws EmployeeServiceFactoryNotFound, EmployeeServiceFactoryTypeNotFound {
        EmployeeServiceFactoryType employeeServiceFactoryType = EmployeeServiceFactoryType.get(factoryType);
        ServiceLoader<EmployeeServiceFactory> serviceFactories = ServiceLoader.load(EmployeeServiceFactory.class);
        for (EmployeeServiceFactory employeeServiceFactory : serviceFactories) {
            if (employeeServiceFactory.getType().equals(employeeServiceFactoryType)) {
                return employeeServiceFactory;
            }
        }
        throw new EmployeeServiceFactoryNotFound(factoryType);
    }

}
