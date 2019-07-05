package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.entity.Order;

import dao.CustomerDao;
import dao.GenericDao;
import model.Customer;

public class GenericTest {

	@Test
	public void placeOrder() {
		
		GenericDao dao = new GenericDao();
		Customer cust = (Customer) dao.fetchById(Customer.class, 23);
		
		Order c = new Order();
		
		c.setOrderDate(new Date());
		c.setAmount(4500);		
		c.setCustomer(cust);
		dao.save(c);
	}

}
