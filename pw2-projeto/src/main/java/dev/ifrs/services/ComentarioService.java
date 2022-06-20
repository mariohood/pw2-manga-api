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
import dev.ifrs.Comentario;

@Path("/comentario")
@Transactional
public class ComentarioService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
  
    public Comentario comentario(@FormParam("pessoa_id") String pessoa_id,
    @FormParam("mensagem") String mensagem){
        Comentario comentario = new Comentario();
        comentario.setPessoa_id(pessoa_id);
        comentario.setMensagem(mensagem);
        comentario.persist();
        return comentario;       


    }
    /* public Comentario comentario(@FormParam("pessoa_id") Long pessoa_id,
                                    @FormParam("manga_id") Long manga_id,
                                    @FormParam("mensagem") String mensagem){
        Comentario comentario = new Comentario();
        
        comentario.setPessoa_id(pessoa_id);
        comentario.setMensagem(mensagem);
        comentario.persistAndFlush();
        Manga manga = Manga.findById(manga_id);
        if (manga == null)
        throw new BadRequestException("Manga not found");

        manga.addComent(comentario);
        manga.persistAndFlush();

        return comentario;       
    } */

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Comentario> list(){
        return Comentario.listAll();
    }
    
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comentario list(@PathParam("id") Long id) {
        return Comentario.findById(id);
    }
}
