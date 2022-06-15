package dev.ifrs.services;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.Anuncio;
import dev.ifrs.Comentario;
import dev.ifrs.Manga;
import dev.ifrs.Pessoa;

@Path("/coment")
public class ComentarioService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Comentario comentario(@FormParam("login") String login, 
                            @FormParam("manga_id") Long manga_id,
                            @FormParam("mensagem") String mensagem){
        
         //refatorar pois são criados duas pessoas para passar para os argumentos.                    
        return new Comentario(new Anuncio(new Pessoa(login), 
                                new Manga(manga_id)), 
                                new Pessoa(login), mensagem);       
    }

    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Comentario> list(){
        return Comentario.listAll();
    }

}
