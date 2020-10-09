package com.benin.sprigbootpostgresql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benin.sprigbootpostgresql.model.Employee;
import com.benin.sprigbootpostgresql.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}
	
	public List<Employee> findAll(){
		List<Employee> employees = employeeRepository.findAll();
		return employees;
		
	}
	public Employee findById(Long id) throws Exception {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if(employee == null) {
			throw new Exception("Cannot find Employee with id: " + id);
		}
		else
			return employee;
	}  

}
