package com.example.springwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springwebservices.entity.Department;
import com.example.springwebservices.entity.Employee;
import com.example.springwebservices.repository.DepartmentRepository;
import com.example.springwebservices.repository.EmployeeRepository;

import lombok.Data;

@Service
@Data
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        // Ensure department exists
        Integer deptId = employee.getDepartment().getId();
        Department department = departmentRepository.findById(deptId)
            .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee existing = getEmployeeById(id);
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setSalary(employee.getSalary());
        // Update department if provided
        Integer deptId = employee.getDepartment().getId();
        Department department = departmentRepository.findById(deptId)
            .orElseThrow(() -> new RuntimeException("Department not found"));
        existing.setDepartment(department);
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
