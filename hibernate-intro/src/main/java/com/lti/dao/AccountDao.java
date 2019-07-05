package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountDao extends GenericDao {

	public List<Transaction> fetchMiniStatement(long acno) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
		
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			String query_line ="select t from Transaction t where t.account.acno = :acno order by t.date desc";
			Query query =  em.createQuery(query_line);
			//query.setFirstResult(10);	Gives the position from where it is started. Used in combination with setMaxResult  
			query.setParameter("acno",acno);
			query.setMaxResults(5);
			List<Transaction> list = query.getResultList();
			return  list;
		}
		finally {
		em.close();
		emf.close();
		}
	}
	
	public List<Account> fetchGreaterThanBalance(double balance) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
		
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			String query_line ="select a from Account a where a.balance > :balance";
			Query query =  em.createQuery(query_line);
			//query.setFirstResult(10);	Gives the position from where it is started. Used in combination with setMaxResult  
			query.setParameter("balance", balance);
			List<Account> list = query.getResultList();
			return  list;
		}
		finally {
		em.close();
		emf.close();
		}
	}
	
	public List<Account> fetchAccountsByActivity(String type, double amount) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
		
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			String query_line ="select a from Account a join a.transactions tx where tx.type = :type and tx.amount >= :amount";
			Query query =  em.createQuery(query_line);
			query.setParameter("amount", amount);
			query.setParameter("type", type);
			List<Account> list = query.getResultList();
			return  list;
		}
		finally {
		em.close();
		emf.close();
		}
	}

}
