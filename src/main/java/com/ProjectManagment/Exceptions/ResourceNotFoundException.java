package com.ProjectManagment.Exceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	// this exception handling local in the application, it pass message if id doesnot exist

	
	
	String resourceName;
	String FieldName;
	
	Integer FieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Integer projectId) {
		super(String.format("%s not  found  with %s : %s",resourceName,fieldName,projectId));
		this.resourceName = resourceName;
		this.FieldName = fieldName;
		this.FieldValue = projectId;
	}
}
