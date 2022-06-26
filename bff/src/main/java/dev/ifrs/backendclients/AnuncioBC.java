package dev.ifrs.backendclients;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.ifrs.model.Anuncio;

@RegisterRestClient(baseUri = "http://localhost:8080/anuncio")
public interface AnuncioBC {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio create (@FormParam("manga_id") Long manga_id,
                            @FormParam("user_id") Long user_id,
                            @FormParam("msgs") String msgs);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> list();

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio getAnuncio(@PathParam("id") Long id);
    
}
