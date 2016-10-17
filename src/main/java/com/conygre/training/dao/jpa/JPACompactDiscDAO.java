package com.conygre.training.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.conygre.training.dao.CompactDiscDAO;
import com.conygre.training.entities.CompactDisc;


@Stateless
@Local
public class JPACompactDiscDAO implements CompactDiscDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void addCompactDisc(CompactDisc disc) {
	
		Query query = em.createQuery("from CompactDisc");
		List<CompactDisc> discs = query.getResultList(); 
		if (!discs.contains(disc))
			em.persist(disc);	
	}


	public CompactDisc getCompactDiscByTitle(String title) {
		// TODO Auto-generated method stub		
		Query query  = em.createQuery("from CompactDisc cd where cd.title = :title");
		query.setParameter("title", title);
		// remember we are assuming only one album has any particular title
		// could have used getSingleResult() but this an exception if there is more than one result
		List<CompactDisc> result = query.getResultList();
		return result.get(0);
	}
	
	
	public Collection<CompactDisc> getDiscsByArtist(String artist) {
		// TODO Auto-generated method stu
		Query query  = em.createQuery("from CompactDisc cd where cd.artist = :artist");
		query.setParameter("artist", artist);
		List<CompactDisc> result = query.getResultList();
		return result;
	}

	public Collection<CompactDisc> getAllDiscs() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from CompactDisc");
		List<CompactDisc> discs = query.getResultList(); 
		return discs;
		
	}

}
