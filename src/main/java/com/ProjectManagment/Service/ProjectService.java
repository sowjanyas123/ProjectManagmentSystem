package com.ProjectManagment.Service;

import java.util.List;

import com.ProjectManagment.Entity.Project;

public interface ProjectService {

	public List<Project> getAllProjects();
	public Project getById(Integer id);
	public Project createProject(Project project);
	public Project updateProject(Project project,int id);
	public void deleteById(int id);
	
	

}
