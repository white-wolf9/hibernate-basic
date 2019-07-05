package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class GenericDao {     //BaseDao,commonDao class
 
	public void save(Object obj) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(obj);   // merge can be used for both update and insert
			et.commit();
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public  Object fetchById(Class classname, Object Id) {   
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
	  emf=Persistence.createEntityManagerFactory("oracle-pu");
	  em=emf.createEntityManager();
	
	Object obj = em.find(classname, Id);
	return obj;
	
		}
		finally {
    em.close();
	emf.close();
		}	
 }
	
	public  <E> List<E> fetchAll(Class<E> clazz) {                                          //fetch all the records in the table
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
		
		emf=Persistence.createEntityManagerFactory("oracle-pu");
		em=emf.createEntityManager();
		
	
		Query q =  em.createQuery("select obj from  " + clazz.getName() + " as obj ");
			//in hibernate we give the class name which find the table name from the class name
		
		List<E> list = q.getResultList();
				return  list;
		}
		finally {
		em.close();
		emf.close();
		}
		
	}
	
	
}
