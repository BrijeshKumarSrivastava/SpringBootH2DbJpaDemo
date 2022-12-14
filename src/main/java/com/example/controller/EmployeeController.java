package com.example.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController  
public class EmployeeController   
{  
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")  
	private List<Employee> getAllEmployees()   
	{  
		return employeeService.getAllEmployees();  
	}  

	@GetMapping("/employee/{id}")  
	private Employee getEmployee(@PathVariable("id") int id)   
	{  
		return employeeService.getEmployeeById(id);  
	}  

	@DeleteMapping("/employee/{id}")  
	private void deleteEmployee(@PathVariable("id") int id)   
	{  
		employeeService.delete(id);  
	}  

	@PostMapping("/employee")  
	private int saveEmployee(@RequestBody Employee employee)   
	{  
		employeeService.saveOrUpdate(employee);  
		return employee.getId();  
	}  
}  

