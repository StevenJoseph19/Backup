package com.example.springwebservices.service;

import com.example.springwebservices.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department getDepartmentById(Integer id);
    List<Department> getAllDepartments();
    Department updateDepartment(Integer id, Department department);
    void deleteDepartment(Integer id);
}
