package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;

public class OrderTest {

	GenericDao dao = new GenericDao();
	
	@Test
	public void testPlaceOrder() {
		Customer customer = (Customer) dao.fetchById(Customer.class, 213);
		Order order = new Order();
		order.setOrderDate(java.sql.Date.valueOf("2019-01-06"));
		order.setAmount(6100);		 
		order.setCustomer(customer);
		dao.save(order);
	}

	
	@Test
	public void testFetchAllOrders() {
		
		List<Order> orders = dao.fetchAll(Order.class);
		for(Order order_iterator : orders) {
			System.out.println(order_iterator);
			/*
			 * System.out.println(order_iterator.getId());
			 * System.out.println(order_iterator.getOrderDate());
			 * System.out.println(order_iterator.getAmount());
			 * System.out.println(order_iterator.getCustomer().getEmail());
			 * System.out.println(order_iterator.getCustomer().getCity());
			 * System.out.println(order_iterator.getCustomer().getName());
			 */
		}
	}
}
