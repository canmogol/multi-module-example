package com.example.employee.internal.repository;

public class EmployeeJDBCError extends Exception {

    private final String error;

    public EmployeeJDBCError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return String.format("%s, parent error: %s", error, super.getMessage());
    }

}
