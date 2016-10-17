package com.conygre.training.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jws.WebService;

import com.conygre.training.dao.CompactDiscDAO;
import com.conygre.training.entities.CompactDisc;
@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class CompactDiscServiceEJB implements CompactDiscService {
	
		
	@EJB // uses reflection
	private CompactDiscDAO dao;
	
//	@Resource
//	private SessionContext context;

	public void setDao(CompactDiscDAO dao) {
		// do something really important on injection
		this.dao = dao;
	}

	
	public void addToCatalog(CompactDisc disc) {
		
			dao.addCompactDisc(disc);
		
	}
	
	public Collection<CompactDisc> getCatalog() {
		return dao.getAllDiscs();
	}
}
