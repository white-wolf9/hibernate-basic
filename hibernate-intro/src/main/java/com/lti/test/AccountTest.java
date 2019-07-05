package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountTest {
	
	AccountService accServ = new AccountService();

	@Test
	public void testOpenAccount() {

		Account acc = new Account();
		acc.setName("MJ");
		acc.setType("Savings");
		acc.setBalance(5000);
		accServ.openAccount(acc);
		
	}
	
	@Test
	public void testWithdraw() {
		accServ.withdraw(141, 100 );
	}
	
	@Test
	public void testDeposit() {
		accServ.deposit(141, 200 );
	}
	
	@Test
	public void testCheckBalance() {
		
		accServ.checkBalance(141);
	}
	
	@Test
	public void testTransfer() {
		accServ.transfer(421, 142, 1000);
	}

	@Test
	public void testMiniStatement() {
		List<Transaction> list = accServ.miniStatement(141);
		for(Transaction t:list) {
			System.out.println(t);
		}
	}
	
	@Test
	public void testGreatBalance() {
		List<Account> list = accServ.greaterBalance(1000);
		for(Account a:list) {
			System.out.println(a);
		}
	}
	
	@Test
	public void testAccountByActivity() {
		List<Account> list = accServ.accountActivity("WITHDRAW",100);
		for(Account a:list) {
			System.out.println(a);
		}
	}
}
