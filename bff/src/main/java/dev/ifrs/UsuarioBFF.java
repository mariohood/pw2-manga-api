package dev.ifrs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.backendclients.UsuarioBC;
import dev.ifrs.model.Usuario;

@Path("/bff/usuario")
public class UsuarioBFF {
    
    @Inject
    @RestClient
    UsuarioBC usuariobc;

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario createBFF(@FormParam("login") String login,
                                @FormParam("password") String password,
                                @FormParam("email") String email){
        return usuariobc.create(login, password, email);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listBFF(){
        return usuariobc.list();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUserBFF(@PathParam("id") Long id){
        return usuariobc.getUser(id);
    }
}
