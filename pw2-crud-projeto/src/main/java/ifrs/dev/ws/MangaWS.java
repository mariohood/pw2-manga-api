package ifrs.dev.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ifrs.dev.model.Manga;

@Path("/manga")
public class MangaWS {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Manga create(@FormParam("mal_id") String mal_id){
        Manga manga = new Manga();
        manga.setMal_id(mal_id);
        manga.persist();
        return manga;
    }
    
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Manga> list(){
        return Manga.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga find(@PathParam("id") Long id){
        return Manga.findById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        System.out.println("entrou  path delet ");
        Manga.deleteById(id);
        System.out.println("EXECUTOU delet ");
    }
}
