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

import dev.ifrs.model.Mensagem;


@RegisterRestClient(baseUri = "http://localhost:8080/mensagem")
public interface MensagemBC {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensagem create (@FormParam("anuncio_id") Long anuncio_id,
                                @FormParam("texto") String texto,
                                @FormParam("user_id") String user_id);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mensagem> list();

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensagem getMsg(@PathParam("id") Long id);
    
}
