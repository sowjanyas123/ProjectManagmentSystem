package com.ProjectManagment.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjectManagment.Entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
	
	

}
