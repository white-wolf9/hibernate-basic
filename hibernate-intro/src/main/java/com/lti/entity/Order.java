package com.lti.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "TBL_ORDER")

public class Order {
     
	@Id
	@GeneratedValue
	@Column(name= "ORDER_ID")
	 private int id;
	
	 private Date orderDate;
	 private double amount;
	 
	 @OneToOne
	 @JoinColumn(name= "PAYID")
	 private Payment payment;
	 
	 @ManyToOne
	 @JoinColumn(name = "CUST_ID")
	 private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", amount=" + amount + ", payment=" + payment
				+ ", customer=" + customer + "]";
	}

	
	 
}
