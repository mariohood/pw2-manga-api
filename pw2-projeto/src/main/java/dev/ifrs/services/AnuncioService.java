package dev.ifrs.services;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.Anuncio;
import dev.ifrs.Manga;
import dev.ifrs.Pessoa;

@Path("/anuncio")
public class AnuncioService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio anuncio(@FormParam("login") String login, 
                            @FormParam("manga_id") Long manga_id){              
        return new Anuncio(new Pessoa(login), new Manga(manga_id));        
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Anuncio> list(){
        return Anuncio.listAll();
    }
                                
}
