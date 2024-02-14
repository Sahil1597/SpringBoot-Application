package com.example.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.response.EmployeeResponse;
import com.example.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
		
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
	@GetMapping("/employees")
	ResponseEntity<List> getAllEmployees(){
		List<EmployeeResponse> employeeResponse = employeeService.getEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
	@PostMapping("/addEmployee")
	ResponseEntity<EmployeeResponse> addEmployee(@RequestBody Employee e){
		EmployeeResponse employeeResponse = employeeService.addNewEmployee(e);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
	@DeleteMapping("/removeEmployee/{id}")
	void deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
		
	}

}
