package dev.ifrs.backendclients;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.ifrs.model.Usuario;
import io.quarkus.oidc.token.propagation.AccessToken;

@RegisterRestClient(baseUri = "http://localhost:8080/usuario")
public interface UsuarioBC {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario create (@FormParam("login") String login,
                            @FormParam("password") String password,
                            @FormParam("email") String email);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public List<Usuario> list ();

    @GET
    @Path("/list/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUser (@PathParam("id") Long id);


}
