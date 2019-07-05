package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.entity.Transaction;

public class MusicalDao extends GenericDao {
	
	public List<Song> fetchSongsByArtist(String name) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
		
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			String query_line ="select s from Song s where s.singer = :singer";
			Query query =  em.createQuery(query_line);
			//query.setFirstResult(10);	Gives the position from where it is started. Used in combination with setMaxResult  
			query.setParameter("singer",name);
			List<Song> list = query.getResultList();
			return  list;
		}
		finally {
		em.close();
		emf.close();
		}
	}
	
	/*
	 * select s from Song s where s.album.name = :aname 
	 */
	
	public List<Album> fetchSongsByAlbum(String name) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
		
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em=emf.createEntityManager();
			String query_line ="select a from Album a join a.songs s where a.name = :aname";
			Query query =  em.createQuery(query_line);
			//query.setFirstResult(10);	Gives the position from where it is started. Used in combination with setMaxResult  
			query.setParameter("aname",name);
			List<Album> list = query.getResultList();
			return  list;
		}
		finally {
		em.close();
		emf.close();
		}
	}
	
}
