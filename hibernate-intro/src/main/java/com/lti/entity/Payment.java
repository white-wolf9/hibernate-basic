package com.lti.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lti.model.enums.PaymentStatus;

@Entity
@Table(name = "TBL_PAYMENT")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name= "PAYID")
	private int id;
	private int amount;
	private String paymentmode;
	private String paymentstatus;
	/* private Enum<PaymentStatus> paymentstatus; */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}

	/*
	 * public void setPaymentstatus(Enum<PaymentStatus> paymentstatus) {
	 * this.paymentstatus = paymentstatus; }
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getPaymentstatus() {
		return paymentstatus; 
	} 
	public void setPaymentstatus(String paymentstatus) { 
		this.paymentstatus = paymentstatus;
	}
	 
	


	
	
	
	
	
	

}
