package com.learning.springboot.cruddemo.dao;

import java.util.List;

import com.learning.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();	
	public void deleteById(int theId);
	public Employee findById(int theId);
	public void save(Employee theEmployee);

}
