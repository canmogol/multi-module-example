package com.example.employee.internal.factory;


import com.example.employee.external.factory.EmployeeServiceFactory;
import com.example.employee.external.factory.EmployeeServiceFactoryType;
import com.example.employee.external.service.EmployeeService;
import com.example.employee.external.service.EmployeeServiceNotFound;
import com.example.employee.external.service.EmployeeServiceType;
import com.example.employee.external.service.EmployeeServiceTypeNotFound;
import com.example.employee.internal.service.InMemoryEmployeeService;
import com.example.employee.internal.service.JDBCEmployeeService;
import com.example.employee.internal.service.NoOpEmployeeService;

public class DefaultEmployeeServiceFactory implements EmployeeServiceFactory {

    @Override
    public EmployeeServiceFactoryType getType() {
        return EmployeeServiceFactoryType.DEFAULT;
    }

    @Override
    public EmployeeService getEmployeeService(String serviceType, String connectionURL)
            throws EmployeeServiceTypeNotFound, EmployeeServiceNotFound {
        EmployeeServiceType type = EmployeeServiceType.get(serviceType);
        switch (type) {
            case JDBC: {
                return new JDBCEmployeeService(connectionURL);
            }
            case IN_MEMORY: {
                return new InMemoryEmployeeService();
            }
            case NO_OP: {
                return new NoOpEmployeeService();
            }
            default: {
                throw new EmployeeServiceNotFound(serviceType, connectionURL);
            }
        }
    }

}
