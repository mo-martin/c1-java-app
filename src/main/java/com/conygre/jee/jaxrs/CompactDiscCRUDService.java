package com.conygre.jee.jaxrs;

import java.util.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.conygre.training.entities.CompactDisc;
import com.conygre.training.entities.CompactDiscList;
import com.conygre.training.services.CompactDiscService;

@Path("/compactdiscs")
public class CompactDiscCRUDService {
	

	@Inject
	private CompactDiscService service;
	

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompactDiscList getCompactDiscs() {
        CompactDiscList discs = new CompactDiscList();
        discs.setDiscCollection(service.getCatalog());
        return discs;
    }



//    @GET
//	@Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//	public CompactDisc getCompactDisc(@PathParam("id") int id) {
//		return library.get(id);
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCompactDisc(CompactDisc disc) {
		disc.setId(0); // make sure the ID is not set
		service.addToCatalog(disc);
	}
	
//	@PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void updateCompactDisc(CompactDisc updatedDisc) {
//		library.put(updatedDisc.getId(), updatedDisc);
//	}
//	@DELETE
//    @Path("/{id}")
//	public void deleteCompactDisc(@PathParam("id") int id) {
//		library.remove(id);
//	}
}