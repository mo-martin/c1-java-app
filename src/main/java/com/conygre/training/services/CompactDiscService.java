package com.conygre.training.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.jws.WebService;

import com.conygre.training.entities.CompactDisc;
@Local
public interface CompactDiscService {

	public Collection<CompactDisc> getCatalog() ;
	public void addToCatalog(CompactDisc disc);
	
}
