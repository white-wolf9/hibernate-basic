package com.lti.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lti.dao.AccountDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Payment;
import com.lti.entity.Transaction;

//classes which contain the business logic 
//are commonly referred to as Service classes
//People also use this naming convention in WebServices (SOAP/REST)
public class AccountService {
	
	AccountDao dao = new AccountDao();

	public void openAccount(Account acc) {
		dao.save(acc);
		//apart from this we might write/execute the code for sending 
		//email to the customer here
	}
	
	public void withdraw(long acno,double amount ) {
		
		Transaction transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setType("WITHDRAW");
		transaction.setAmount(amount);
		
		Account account= (Account) dao.fetchById(Account.class, acno);
		double balance=account.getBalance();
		if(balance>amount)
		{
			balance = balance -amount;
			account.setBalance(balance);
			dao.save(account);
		}
		else {
			System.out.println("NO!");
		}
		transaction.setAccount(account);
		/*Set<Transaction> transset = new HashSet<Transaction> ();
		transset.add(transaction);
		account.setTransactions(transset);*/
		dao.save(transaction);
	}
	
public void deposit(long acno,double amount ) {
		
		Transaction transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setType("DEPOSIT");
		transaction.setAmount(amount);
		
		Account account= (Account) dao.fetchById(Account.class, acno);
		double balance=account.getBalance();
		balance = balance +amount;
		account.setBalance(balance);
		dao.save(account);
		transaction.setAccount(account);
		/*Set<Transaction> transset = new HashSet<Transaction> ();
		transset.add(transaction);
		account.setTransactions(transset);*/
		dao.save(transaction);
		
	}
	
	public void transfer(long fromAcno, long toAcno, double amount ) {
		
		Transaction transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setType("TRANSFER_TO "+toAcno);
		transaction.setAmount(amount);
		
		Account account= (Account) dao.fetchById(Account.class, fromAcno);
		double balance=account.getBalance();
		if(balance>amount)
		{
			balance = balance -amount;
			account.setBalance(balance);
			dao.save(account);
		}
		else {
			System.out.println("NO!");
		}
		transaction.setAccount(account);
		/*Set<Transaction> transset = new HashSet<Transaction> ();
		transset.add(transaction);
		account.setTransactions(transset);*/
		dao.save(transaction);
		
		transaction.setDate(new Date());
		transaction.setType("TRANSFER_FROM "+fromAcno);
		transaction.setAmount(amount);
		
		account= (Account) dao.fetchById(Account.class, toAcno);
		balance=account.getBalance();
		balance = balance +amount;
		account.setBalance(balance);
		dao.save(account);
		transaction.setAccount(account);
		/*Set<Transaction> transset = new HashSet<Transaction> ();
		transset.add(transaction);
		account.setTransactions(transset);*/
		dao.save(transaction);
		
		
	}
	
	public void checkBalance(long acno ) {
		Account account = (Account) dao.fetchById(Account.class, acno);
		System.out.println(account.getBalance());
	}
	
	public List<Transaction> miniStatement(long acno) {
		List<Transaction> list = dao.fetchMiniStatement(acno);
		return list;
	}
	
	public List<Account> greaterBalance(double balance) {
		List<Account> list = dao.fetchGreaterThanBalance(balance);
		return list;
	}
	
	public List<Account> accountActivity(String type, double amount) {
		List<Account> list = dao.fetchAccountsByActivity(type,amount);
		return list;
	}
}
