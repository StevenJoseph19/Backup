package com.example.springwebservices.service;

import java.util.List;

import com.example.springwebservices.entity.Project;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Integer id);
    List<Project> getAllProjects();
    Project updateProject(Integer id, Project project);
    void deleteProject(Integer id);
}
