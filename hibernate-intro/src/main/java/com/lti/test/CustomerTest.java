package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerTest {

	CustomerDao dao = new CustomerDao();
	
	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setName("Saurav");
		customer.setEmail("hunter.devil12@gmail.com");
		customer.setCity("Kolkata");
		customer.setDob(java.sql.Date.valueOf("1997-12-06"));
		dao.addCustomer(customer);
	}

	@Test
	public void testFetchByEmail() {
		List<Customer> customers = dao.fetchCustomerByEmail("gmail");
		for (Customer customer_iterator:customers) {
			System.out.println(customer_iterator.getId());
			System.out.println(customer_iterator.getName());
			System.out.println(customer_iterator.getCity());
			System.out.println(customer_iterator.getEmail());
			System.out.println(customer_iterator.getDob());
		}
	}
	
	@Test
	public void testFetchAll() {
		List<Customer> customers = dao.fetchAll();
		for (Customer customer_iterator:customers) {
			System.out.println(customer_iterator.getId());
			System.out.println(customer_iterator.getName());
			System.out.println(customer_iterator.getCity());
			System.out.println(customer_iterator.getEmail());
			System.out.println(customer_iterator.getDob());
		}
	}
	
	@Test
	public void testUpdate() {
		Customer customer = dao.fetchById(5);
		customer.setCity("Chennai");
		dao.updateCustomer(customer);
	}

	@Test
	public void testFetchById() {
		System.out.println(dao.fetchById(4));
	}
	
	@Test
	public void testDelete() {
		Customer customer = dao.fetchById(5);
		dao.deleteCustomer(customer);
	}
}
