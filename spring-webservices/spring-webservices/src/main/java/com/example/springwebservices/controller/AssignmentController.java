package com.example.springwebservices.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwebservices.entity.Employee;
import com.example.springwebservices.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/assign/{employeeId}")
    public ResponseEntity<Employee> assignProjects(
            @PathVariable Integer employeeId,
            @RequestBody Set<Integer> projectIds) {
        Employee updated = assignmentService.assignProjectsToEmployee(employeeId, projectIds);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/unassign/{employeeId}")
    public ResponseEntity<Employee> unassignProjects(
            @PathVariable Integer employeeId,
            @RequestBody Set<Integer> projectIds) {
        Employee updated = assignmentService.unassignProjectsFromEmployee(employeeId, projectIds);
        return ResponseEntity.ok(updated);
    }
}
