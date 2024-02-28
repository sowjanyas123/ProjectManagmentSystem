package com.ProjectManagment.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ProjectManagment.Entity.Project;
import com.ProjectManagment.Repositary.ProjectRepo;
import com.ProjectManagment.Service.impl.ProjectServiceImpl;

 class ServiceTest {
	
	 @Mock
	 private ProjectRepo repo;

	 @InjectMocks
	  private ProjectServiceImpl service;
	    
	    
	 @SuppressWarnings("deprecation")
	@BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	 @Test
	    void testGetAllProjects() {
	        Project project1 = new Project(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5));
	        Project project2 = new Project(2, "Project 2", "Description 2", LocalDate.now(), LocalDate.now().plusDays(10));
	        List<Project> projects = Arrays.asList(project1, project2);

	        when(repo.findAll()).thenReturn(projects);

	        List<Project> result = service.getAllProjects();

	        assertEquals(2, result.size());
	        assertEquals(project1, result.get(0));
	        assertEquals(project2, result.get(1));
	        System.out.println(result);
	    }
	 @Test
	    void testGetById() {
	        Project project = new Project(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5));
	        when(repo.findById(1)).thenReturn(Optional.of(project));

	        Project result = service.getById(1);

	        assertEquals(project, result);
	    }
	 @Test
	    void testCreateProject() {
	        Project project = new Project(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5));
	        when(repo.save(project)).thenReturn(project);

	        Project result = service.createProject(project);

	        assertEquals(project, result);
	    }
	 @Test
	    void testUpdateProject() {
	        // Create sample data
	        int projectId = 1;
	        Project existingProject = new Project(projectId, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5));
	        Project updatedProject = new Project(projectId, "Updated Project", "Updated Description", LocalDate.now(), LocalDate.now().plusDays(10));

	        // Mock repository behavior
	        when(repo.findById(projectId)).thenReturn(Optional.of(existingProject));
	        when(repo.save(any(Project.class))).thenReturn(updatedProject);

	        // Call the method under test
	        Project result = service.updateProject(updatedProject, projectId);

	        // Verify that findById and save methods are called
	        verify(repo, times(1)).findById(projectId);
	        verify(repo, times(1)).save(any(Project.class));

	        // Assert the result
	        assertNotNull(result);
	        assertEquals(updatedProject, result);
	    }

	 
	 @Test
	    void testDeleteById() {
	        Project project = new Project(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5));
	        when(repo.findById(1)).thenReturn(Optional.of(project));

	        service.deleteById(1);

	        verify(repo, times(1)).delete(project);
	    }


}
