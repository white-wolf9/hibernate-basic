package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name ="TBL_ACC")
public class Account {
	
     @Id
     @GeneratedValue
	 private long acno;
	 private String name;
	 
	 @Column(name ="AC_TYPE")
	 private String type;
	 
	 private double balance;
	
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
     private Set<Transaction> transactions;


	@Override
	public String toString() {
		return "Account [acno=" + acno + ", name=" + name + ", type=" + type + ", balance=" + balance
				+ ", transactions=" + transactions + "]";
	}

	public long getAcno() {
		return acno;
	}


	public void setAcno(long acno) {
		this.acno = acno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
