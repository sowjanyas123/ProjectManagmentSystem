package com.ProjectManagment.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// this method globally handle exception not only in application 
//also outside the application like here  handling postman api testing and handling exception



@RestControllerAdvice
public class GlobalException {
	  @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundException exception) {
	       Map map=new HashMap();
	       map.put("message", exception.getMessage());
	       map.put("success",false);
	       map.put("status",HttpStatus.NOT_FOUND);
	       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

	    }
	  
	  
	 
}
