package dev.ifrs.services;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.Manga;

@Path("/manga")
public class MangaService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga manga(@FormParam("id") Long id){return new Manga(id);}

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Manga> list(){ return Manga.listAll();}
    
}
