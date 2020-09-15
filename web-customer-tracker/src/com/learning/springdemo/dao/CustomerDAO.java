package com.learning.springdemo.dao;

import java.util.List;

import com.learning.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer cust);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
