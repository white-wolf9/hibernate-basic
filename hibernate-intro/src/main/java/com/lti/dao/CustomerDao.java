package com.lti.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {

	public void addCustomer(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(customer);
			tx.commit();
		}
		finally
		{
			em.close();
			emf.close();
		}
		
	}
	
	public  List<Customer> fetchAll() {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			Query q =  em.createQuery("select  c from Customer as c");
			List<Customer> list = q.getResultList();
			return list;
		}
		finally {
		em.close();
		emf.close();
		}
	}
	
		
	public  List<Customer> fetchCustomerByEmail(String email) {   
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			Query q =  em.createQuery("select  c from Customer as c where c.email like :em");
			q.setParameter("em","%" + email +"%");
			List<Customer> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
			emf.close();
		}	
	}
	
	public void updateCustomer(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(customer);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public void deleteCustomer(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(customer);
			tx.commit();
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public Customer fetchById(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			Customer customer = em.find(Customer.class, id);
			return customer;
		}
		finally {
			em.close();
			emf.close();
		}
	}
}
