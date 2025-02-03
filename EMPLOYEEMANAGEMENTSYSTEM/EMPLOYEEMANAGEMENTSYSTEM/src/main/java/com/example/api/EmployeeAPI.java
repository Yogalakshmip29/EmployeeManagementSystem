package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.dto.EmployeeDTO;
import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.serviceImpl.EmployeeServiceImpl;

@RestControllerAdvice
@RequestMapping(value="/api/v1")
public class EmployeeAPI {
   
@Autowired
private EmployeeServiceImpl ser;



@GetMapping(produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},value="/get/{id}")
public ResponseEntity<Employee> get(@PathVariable Integer id ) throws ResourceNotFoundException{
	
	Employee emp=ser.get(id);
	return new ResponseEntity<>(emp,HttpStatus.OK);
	
}



@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,value="/post")
public ResponseEntity<String> add(@RequestBody EmployeeDTO dt ,@RequestParam(name="v1",defaultValue="10") String version) throws ResourceNotFoundException{
	
	ser.addEmployee(null);
	String s="data is successfull";
	return new ResponseEntity<>(s, HttpStatus.OK);
}




}
