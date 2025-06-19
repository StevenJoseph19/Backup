package com.example.springwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springwebservices.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
