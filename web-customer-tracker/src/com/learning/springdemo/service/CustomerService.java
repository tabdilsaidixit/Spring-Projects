package com.learning.springdemo.service;

import java.util.List;

import com.learning.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer cust);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	
}
