package com.ProjectManagment.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectManagment.Entity.Project;
import com.ProjectManagment.Service.ProjectService;

import Payload.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	ProjectService serv;
	
	
	//Create all Records
	@PostMapping("/create")
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project createdProject = serv.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

	
	//Get All records
	 @GetMapping("/getAll")
	    public ResponseEntity<List<Project>> getAllProjects() {
	        List<Project> projects = serv.getAllProjects();
	        return ResponseEntity.ok(projects);
	    }
	 
	 
	 //Update record by Id
	 @PutMapping("/{id}")
	    public ResponseEntity<Project> updateProject(@Valid @PathVariable int id, @RequestBody Project project) {
	        Project updatedProject = serv.updateProject(project, id);
	        return ResponseEntity.ok(updatedProject);
	    }
	 
	 
	//Delete record by id 
	   @DeleteMapping("/{id}")
	    public ResponseEntity<ApiResponse> deleteProject(@PathVariable int id) {
            serv.deleteById(id);
            return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully", true),HttpStatus.OK);

	            }
	   
	   
	   //Get project by Id
	     @GetMapping("/{id}")
	        public ResponseEntity<Project> GetProjectById(@PathVariable int id){
	        	Project getById = serv.getById(id);
	    		return new ResponseEntity<Project>(getById,HttpStatus.OK);

	        	   }
	    	


}
