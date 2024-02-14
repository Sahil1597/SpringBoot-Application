package com.example.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.repository.EmployeeRepository;
import com.example.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public EmployeeResponse getEmployeeById(int id) {
	Employee employee = employeeRepository.findById(id).get();
	
	EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
	return employeeResponse;
	}

	public List<EmployeeResponse> getEmployees() {
		List<Employee> employee = employeeRepository.findAll();
	
		List<EmployeeResponse> employeeResponse = modelMapper.map(employee, List.class);
		return employeeResponse;
	}

	public EmployeeResponse addNewEmployee( Employee e) {
		Employee employee = employeeRepository.save(e);
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		return employeeResponse;
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}
