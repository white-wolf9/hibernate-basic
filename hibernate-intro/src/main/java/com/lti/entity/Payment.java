package com.lti.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	/* private String paymentstatus; */
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentstatus; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	 
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public PaymentStatus getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(PaymentStatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	/*public String getPaymentstatus() {
		return paymentstatus; 
	} 
	public void setPaymentstatus(String paymentstatus) { 
		this.paymentstatus = paymentstatus;
	}
	 */
	


	
	
	
	
	
	

}
