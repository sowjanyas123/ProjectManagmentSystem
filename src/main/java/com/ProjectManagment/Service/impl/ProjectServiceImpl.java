package com.ProjectManagment.Service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectManagment.Entity.Project;
import com.ProjectManagment.Exceptions.ResourceNotFoundException;
import com.ProjectManagment.Repositary.ProjectRepo;
import com.ProjectManagment.Service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {
@Autowired
ProjectRepo repo;

//build logic for every method from this service-impl layer
// for CRUD Operation


	@Override
	public List<Project> getAllProjects() {
		List<Project> getAll = repo.findAll();
		return getAll;
	}

	@Override
	public Project getById(Integer id) {
		 Project getById = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project", "Project Id", id));
		return getById;
	}

	@Override
	public Project createProject(Project project) {
		Project save = repo.save(project);
		return save;
	}

	@Override
	public Project updateProject(Project project, int id) {
		Project update = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project", "Project id", id));
		update.setName(project.getName());
		update.setDescription(project.getDescription());
		update.setEndDate(project.getEndDate());
		update.setStartDate(project.getStartDate());
		Project saved = repo.save(update);
		return saved;
	}
	
	
	
	
	@Override
	public void deleteById(int id) {
Project findId=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project", "Project id", id));
		repo.delete(findId);

	}

}
