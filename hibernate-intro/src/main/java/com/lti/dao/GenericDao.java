package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class GenericDao {
 
	public void save(Object object) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(object);
			tx.commit();
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public  Object fetchById(Class classname, Object id) {   
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			Object obj = em.find(classname, id);
			return obj;
		}
		finally {
			em.close();
			emf.close();
		}	
	}
	
	public  <E> List<E> fetchAll(Class<E> classobject) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			Query q =  em.createQuery("select obj from  " + classobject.getName() + " as obj ");
			List<E> list = q.getResultList();
			return  list;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public void delete(Class classname, Object id) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Object object = em.find(classname, id);
			em.remove(object);
			tx.commit();
		}
		finally {
			em.close();
			emf.close();
		}
	}
}
