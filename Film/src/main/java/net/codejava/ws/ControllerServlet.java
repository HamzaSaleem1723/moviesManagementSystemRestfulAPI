package net.codejava.ws;

import java.util.*;


import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/filmapi")
public class ControllerServlet {
	private FilmDAO filmDAO = new FilmDAO();
    
    //Get Request Handler for JSON

    @GET
    @Path("/j")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAllFilmJSON(){
    	ArrayList<Film> filmList = filmDAO.getAllFilms();
    	return filmList;
    }
    
    //Get Request Handler for XML

    @GET
    @Path("/x")
    @Produces(MediaType.APPLICATION_XML)
    public List<Film> getAllFilmXML(){
    	ArrayList<Film> filmList = filmDAO.getAllFilms();
    	return filmList;
    }
	
    
    //Get Request Handler by id for XML, JSON, TEXT_PLAIN
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Film filmGet(@PathParam("id") int id){
    	Film f = filmDAO.getFilmByID(id);
    	return f;
    }
    
    //Post Request Handler to insert film for XML, JSON, TEXT_PLAIN
    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public String filmInsert(Film f) {
		filmDAO.insertFilm(f);
		return "Inserted";
		
	}
    
    //Put Request Handler to update film for XML, JSON, TEXT_PLAIN
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public String updateFilm (@PathParam("id") int id,Film f) {
		filmDAO.updateFilm(f, id);
		return "Updated";
		
	}
    
    //Delete Request Handler to delete film for XML, JSON, TEXT_PLAIN
    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public String filmDelete (@PathParam("id") int id) {
		filmDAO.deleteFilm(id);
		return "Deleted";
		
	}
    	
}
