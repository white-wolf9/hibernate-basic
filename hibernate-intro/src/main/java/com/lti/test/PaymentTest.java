package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;
import com.lti.entity.Payment;

public class PaymentTest {

	@Test
public void orderPayment() {
		
		GenericDao dao = new GenericDao();
		Payment p = new Payment();
		
		p.setAmount(5000);
		p.setPaymentmode("cash");
		p.setPaymentstatus("pass");
		
		dao.save(p);
	}
	
	@Test
	public void linkPayment() {
		GenericDao dao=new GenericDao();
		Order o=(Order) dao.fetchById(Order.class, 95);
		Payment p=(Payment) dao.fetchById(Payment.class,1);
		o.setPayment(p);
		dao.save(o);
	}


}