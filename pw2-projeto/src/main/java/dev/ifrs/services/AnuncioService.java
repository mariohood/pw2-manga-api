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
import dev.ifrs.Pessoa;

@Path("/anuncio")
public class AnuncioService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Anuncio anuncio(@FormParam("estrelas") String estrelas, 
                            @FormParam("id") Long id){              
        Anuncio anuncio = new Anuncio();
        anuncio.setEstrelas(estrelas);
        anuncio.persist();
        Pessoa pessoa = Pessoa.findById(id);
        if (pessoa == null)
        throw new BadRequestException("Pessoa not fund");

        pessoa.addAnuncios(anuncio);
        pessoa.persistAndFlush();
        return anuncio;       
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Anuncio> list(){
        return Anuncio.listAll();
    }
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio find(@PathParam("id") Long id){
        return Anuncio.findById(id);
    }                     
}
