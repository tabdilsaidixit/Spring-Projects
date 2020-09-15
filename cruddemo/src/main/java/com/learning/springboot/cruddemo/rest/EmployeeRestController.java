package com.learning.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.cruddemo.dao.EmployeeDAO;
import com.learning.springboot.cruddemo.entity.Employee;
import com.learning.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
 	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
 	
 	@GetMapping("/employees/{theId}")
	public Employee getEmployeeById(@PathVariable int theId ){
		return employeeService.findById(theId);
	}
 	
 	@DeleteMapping("/employees/{theId}")
 	public void deleteEmployeeById(@PathVariable int theId) {
 		employeeService.deleteById(theId);
 	}
 	
 	@PostMapping("/employees")
 	public void createEmployee(@RequestBody Employee theEmployee) {
 		theEmployee.setId(0);
 		employeeService.save(theEmployee);
 	}
 	
 	@PutMapping("/employees")
 	public void updateEmployee(@RequestBody Employee theEmployee) {
 		employeeService.save(theEmployee);
 	}

}
