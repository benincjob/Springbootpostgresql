package com.benin.sprigbootpostgresql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.benin.sprigbootpostgresql.model.Employee;
import com.benin.sprigbootpostgresql.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = {"/", "index"})
	public String index(Model model) {
		return "index";
	}
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employee-list";
	
	}
	@GetMapping(value="/employees/{employeeId}")
	public String getEmployeeById(Model model, @PathVariable long employeeId) {		
		
		Employee employee = null;
		
		try {
			employee = employeeService.findById(employeeId);
		} catch(Exception e) {
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", "Employee not found.");
		}
		
		model.addAttribute("employee", employee);
		return "employee";
	} 

}
