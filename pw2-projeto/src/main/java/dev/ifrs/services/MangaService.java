package dev.ifrs.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.Anuncio;
import dev.ifrs.Manga;

@Path("/manga")
public class MangaService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Manga manga(@FormParam("pessoa_id") Long pessoa_id,
                        @FormParam("texto") String texto, 
                        @FormParam("anuncio_id") Long anuncio_id){
        Manga manga = new Manga();
        manga.setPessoa_id(pessoa_id);
        manga.setTexto(texto);
        manga.persist();
        Anuncio anuncio = Anuncio.findById(anuncio_id);
        if (anuncio == null)
        throw new BadRequestException("Anuncio não encontrado");
        anuncio.addMangas(manga);
        anuncio.persistAndFlush();

        return manga;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Manga> list(){ return Manga.listAll();}
    
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga find(@PathParam("id") Long id) {
        return Manga.findById(id);
    } 

}
