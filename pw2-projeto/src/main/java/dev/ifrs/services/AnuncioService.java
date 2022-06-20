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
import dev.ifrs.Anuncio;

@Path("/anuncio")
@Transactional
public class AnuncioService {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio anuncio(@FormParam("mangas") String mangas,
                            @FormParam("estrelas") String estrelas){
                                
            Anuncio anuncio = new Anuncio();
            anuncio.setMangas(mangas);
            anuncio.setEstrelas(estrelas);
            System.out.println("WS Anuncio CREATE: " + anuncio);
            anuncio.persist();
            return anuncio;
    }
                        
   /*  public Anuncio anuncio(@FormParam("pessoa_id") Long pessoa_id, 
                            @FormParam("manga_id") Long manga_id){              
        Anuncio anuncio = new Anuncio();
        System.out.println("antes do Manga.findbyID: " + manga_id);
        anuncio.addManga(Manga.findById(manga_id));
        anuncio.persist();
        System.out.println("depois do Manga.findbyID: " + Manga.findById(manga_id)); 
       
        System.out.println("antes do Pessoa.findbyID: " + pessoa_id);
        Pessoa pessoa = Pessoa.findById(pessoa_id);    
        System.out.println("depois do Pessoa.findbyID: " + pessoa);   
        if (pessoa == null)
                throw new BadRequestException("User not found");
        
        pessoa.addAnuncio(anuncio);
        pessoa.persistAndFlush();

        return anuncio;        
    } */

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Anuncio> list(){
        return Anuncio.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio list(@PathParam("id") Long id) {
        return Anuncio.findById(id);
    }                       
}
