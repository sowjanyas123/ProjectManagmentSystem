package com.ProjectManagment.Entity;


// this entity class build ORM with H2 Database using Hibernate framework
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "projects")


public class Project {

	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @NotBlank(message = "Name is required")
	    private String name;
	    
	    
	    @NotBlank(message = "Description is required")
	    private String description;
	    
	    
	   
	    private LocalDate startDate;
	    
	    	
	    private LocalDate endDate;
	  

	}


