package com.learning.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springboot.cruddemo.dao.EmployeeDAO;
import com.learning.springboot.cruddemo.dao.EmployeeRepository;
import com.learning.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
//	@Autowired
//	private EmployeeDAO employeeDAO;
	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result = employeeDAO.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - "+ theId);
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

}
