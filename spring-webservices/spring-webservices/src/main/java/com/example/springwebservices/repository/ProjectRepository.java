package com.example.springwebservices.repository;

import com.example.springwebservices.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {}
