package com.example.employee.internal.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JDBCEmployeeRepository {

    private final String jdbcConnectionURL;

    public JDBCEmployeeRepository(String jdbcConnectionURL) {
        this.jdbcConnectionURL = jdbcConnectionURL;
    }

    public Optional<Employee> findOne(UUID id) throws EmployeeJDBCError {
        try (Statement statement = getConnection().createStatement()) {
            String query = String.format(Employee.FIND_BY_ID, id);
            try (ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    return Optional.of(createEmployee(resultSet));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            String error = String.format("Exception occurred at database operation, error: %s", e.getMessage());
            throw new EmployeeJDBCError(error);
        }
    }

    public List<Employee> findAll() throws EmployeeJDBCError {
        List<Employee> employees = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(Employee.FIND_ALL)) {
                while (resultSet.next()) {
                    employees.add(createEmployee(resultSet));
                }
            }
        } catch (SQLException e) {
            String error = String.format("Exception occurred at database operation, error: %s", e.getMessage());
            throw new EmployeeJDBCError(error);
        }
        return employees;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcConnectionURL);
    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getBoolean("retired"));
    }

}
