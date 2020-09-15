package com.learning.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository 
extends JpaRepository<Employee, Integer> {

}
