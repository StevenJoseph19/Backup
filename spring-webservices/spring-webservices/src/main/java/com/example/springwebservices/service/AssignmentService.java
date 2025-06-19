package com.example.springwebservices.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springwebservices.entity.Employee;
import com.example.springwebservices.entity.Project;
import com.example.springwebservices.repository.EmployeeRepository;
import com.example.springwebservices.repository.ProjectRepository;

@Service
public class AssignmentService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public Employee assignProjectsToEmployee(Integer employeeId, Set<Integer> projectIds) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        Set<Project> projects = projectRepository.findAllById(projectIds).stream().collect(Collectors.toSet());
        employee.setProjects(projects);
        return employeeRepository.save(employee);
    }

    public Employee unassignProjectsFromEmployee(Integer employeeId, Set<Integer> projectIds) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.getProjects().removeIf(project -> projectIds.contains(project.getId()));
        return employeeRepository.save(employee);
    }
}

