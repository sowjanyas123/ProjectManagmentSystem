package com.ProjectManagment.ServiceTest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ProjectManagment.Entity.Project;
import com.ProjectManagment.RestController.ProjectController;
import com.ProjectManagment.Service.ProjectService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerIntegrationTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Test
    public void testGetAllProjects() throws Exception {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5)));
        projects.add(new Project(1, "Project 2", "Description 2", LocalDate.now(), LocalDate.now().plusDays(10)));
        
        when(projectService.getAllProjects()).thenReturn(projects);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/project/getAll")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    public void testGetProjectById() throws Exception {
        Project project = new Project(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(5));
        when(projectService.getById(1)).thenReturn(project);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/project/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Project 1"));
    }
    
    @Test
    public void testDeleteProjectById() throws Exception {
        // Setup: Mock the behavior of ProjectService.deleteByID()
        int projectIdToDelete = 1; // Example ID to delete
        doNothing().when(projectService).deleteById(projectIdToDelete);

        // Perform the DELETE request to delete the project by ID
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/project/{id}", projectIdToDelete)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
        
        // Verify that ProjectService.deleteById() was called with the correct ID
        verify(projectService, times(1)).deleteById(projectIdToDelete);
    }
    
  


}
