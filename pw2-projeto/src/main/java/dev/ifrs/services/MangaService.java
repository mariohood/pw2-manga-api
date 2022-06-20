package dev.ifrs.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dev.ifrs.Manga;

@Path("/manga")
@Transactional
public class MangaService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga manga(@FormParam("manga_id") Long manga_id){
        Manga manga = new Manga();
        manga.setManga_id(manga_id);
        manga.persist();
        return manga;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Manga> list(){ 
        return Manga.listAll();
    }
    
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga list(@PathParam("id") Long id) {
        return Manga.findById(id);
    }
}
