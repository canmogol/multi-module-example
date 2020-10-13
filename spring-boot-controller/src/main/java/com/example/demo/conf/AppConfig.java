package com.example.demo.conf;

import com.example.employee.external.factory.EmployeeServiceFactory;
import com.example.employee.external.factory.EmployeeServiceFactoryNotFound;
import com.example.employee.external.factory.EmployeeServiceFactoryType;
import com.example.employee.external.factory.EmployeeServiceFactoryTypeNotFound;
import com.example.employee.external.service.EmployeeService;
import com.example.employee.external.service.EmployeeServiceNotFound;
import com.example.employee.external.service.EmployeeServiceTypeNotFound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${employeeService.type:NO_OP}")
    private String employeeServiceType;

    @Value("${employeeService.connectionURL}")
    private String employeeServiceConnectionURL;

    @Bean
    public EmployeeService getEmployeeService()
            throws EmployeeServiceFactoryTypeNotFound, EmployeeServiceFactoryNotFound,
            EmployeeServiceTypeNotFound, EmployeeServiceNotFound {
        String defaultFactory = EmployeeServiceFactoryType.DEFAULT.name();
        EmployeeServiceFactory employeeServiceFactory =
                EmployeeServiceFactory.getEmployeeServiceFactory(defaultFactory);
        return employeeServiceFactory.getEmployeeService(employeeServiceType, employeeServiceConnectionURL);
    }

}
