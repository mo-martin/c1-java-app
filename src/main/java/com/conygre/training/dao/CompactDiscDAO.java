package com.conygre.training.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.conygre.training.entities.CompactDisc;
@Local
public interface CompactDiscDAO {
	
	void addCompactDisc(CompactDisc disc);
	CompactDisc getCompactDiscByTitle(String title);
	Collection<CompactDisc> getDiscsByArtist(String artist);
	Collection<CompactDisc> getAllDiscs();
}
