package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;
import com.lti.entity.Payment;
import com.lti.model.enums.PaymentStatus;

public class PaymentTest {

	GenericDao dao = new GenericDao();
	
	@Test
	public void testMakePayment() {	
		Payment payment = new Payment();
		payment.setAmount(7500);
		payment.setPaymentmode("Cash");
		/* payment.setPaymentstatus("Pass"); */
		payment.setPaymentstatus(PaymentStatus.Pass);
		dao.save(payment);
		
		/*
		 * Trying to save enum value in database stores an absurdly long string.
		 */
	}
	
	@Test
	public void testLinkPayment() {
		Order order = (Order) dao.fetchById(Order.class, 214);
		Payment payment = (Payment) dao.fetchById(Payment.class, 216);
		order.setPayment(payment);
		dao.save(order);
	}


}