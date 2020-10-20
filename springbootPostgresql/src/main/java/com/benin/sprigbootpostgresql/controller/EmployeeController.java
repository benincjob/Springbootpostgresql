package com.benin.sprigbootpostgresql.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping(value = {"/employees/add"})
	public String showAddEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("add", true);
		model.addAttribute("employee", employee);
		return "employee-edit";
	}
	
	
	@PostMapping(value="/employees/add")
	public String addEmployee(Model model,
			                  @ModelAttribute("employee") Employee employee) {
		try {
			
			Employee newEmployee = employeeService.save(employee);
			return "redirect:/employees/" + String.valueOf(newEmployee.getId());
			
		} catch(Exception e) {
		
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("add", true);
			return "employee-edit";
		}
	}
	
	@GetMapping(value= {"/employees/{employeeId}/edit"})
	public String showEditEmployee(Model model, 
			                       @PathVariable long employeeId) {
		Employee employee = null;
		try {
			
			employee = employeeService.findById(employeeId);
			
		} catch(Exception e) {
			model.addAttribute("errorMessage", "Employee not found");
		}
		
		model.addAttribute("add", false);
		model.addAttribute("employee", employee);
		
		return "employee-edit";
	}
	
	@PostMapping(value= {"/employees/{employeeId}/edit"})
	public String updateEmployee(Model model,
			                     @PathVariable long employeeId,
			                     @ModelAttribute("employee") Employee employee) {
		try {
			employee.setId(employeeId);
			employeeService.update(employee);
			return "redirect:/employees/" + String.valueOf(employee.getId());
			
		} catch(Exception e) {
			
			String errorMessage = e.getMessage();
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("add", false);
			return "employee-edit";
		}
	}
	
}
	

