package ifrs.dev.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ifrs.dev.model.Anuncio;

@Path("/anuncio")
public class AnuncioWS {
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Anuncio create(@FormParam("manga") String manga,
                            @FormParam("aval") String aval,
                            @FormParam("msgs") String msgs){
        Anuncio anuncio = new Anuncio();
        anuncio.setAval(aval);
        anuncio.setManga(manga);
        anuncio.setMsgs(msgs);
        anuncio.persistAndFlush();
        return anuncio;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> list(){
        return Anuncio.listAll();
    }
}
