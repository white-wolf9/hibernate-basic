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
		Account account = new Account();
		account.setName("Rishab Gautam");
		account.setType("Savings");
		account.setBalance(15000);
		accServ.openAccount(account);
	}
	
	@Test
	public void testAccountWithdraw() {
		accServ.withdrawFromAccount(24, 1000);
	}
	
	@Test
	public void testAccountDeposit() {
		accServ.depositToAccount(24, 1000);
	}
	
	@Test
	public void testCheckBalance() {
		accServ.checkAccountBalance(24);
	}
	
	@Test
	public void testTransfer() {
		accServ.transferFromAccountToAccount(26, 24, 5000);
	}

	@Test
	public void testMiniStatement() {
		List<Transaction> list = accServ.miniStatement(24);
		for(Transaction transaction_iterator:list) {
			System.out.println(transaction_iterator);
		}
	}
	
	@Test
	public void testGreaterBalance() {
		List<Account> list = accServ.greaterBalanceThan(1000);
		for(Account account_iterator:list) {
			System.out.println(account_iterator);
		}
	}
	
	@Test
	public void testAccountByActivity() {
		List<Account> list = accServ.accountActivity("WITHDRAW",100);
		for(Account account_iterator:list) {
			System.out.println(account_iterator);
		}
	}
}
