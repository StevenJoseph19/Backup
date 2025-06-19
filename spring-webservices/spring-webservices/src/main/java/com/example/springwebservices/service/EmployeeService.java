package com.example.springwebservices.service;

import java.util.List;

import com.example.springwebservices.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);
}