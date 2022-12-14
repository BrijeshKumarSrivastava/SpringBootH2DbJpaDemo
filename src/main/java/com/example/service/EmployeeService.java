package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	//getting all employees records
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();  
		employeeRepository.findAll().forEach(employee -> employees.add(employee));  
		return employees;  
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	public void delete(int id) {
		employeeRepository.deleteById(id);  
	}

	public void saveOrUpdate(Employee employee) {
	employeeRepository.save(employee);
		
	}

}
