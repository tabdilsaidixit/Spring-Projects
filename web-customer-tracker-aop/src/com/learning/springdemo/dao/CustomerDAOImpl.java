package com.learning.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession =  sessionFactory.getCurrentSession();
		
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer cust) {
		Session currentSession =  sessionFactory.getCurrentSession();
		System.out.println(cust);
		currentSession.saveOrUpdate(cust);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession =  sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession =  sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete Customer where id = :theCusId");
		query.setParameter("theCusId", theId);
		int result = query.executeUpdate();
	}

}
