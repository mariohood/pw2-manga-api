package dev.ifrs;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.backendclients.LoginBC;
import dev.ifrs.backendclients.UsuarioBC;
import dev.ifrs.model.Usuario;

@Path("/bff/usuario")
public class UsuarioBFF {
            
    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim(standard = Claims.email)
    String eMail;
    
    @Inject
    @RestClient
    UsuarioBC usuariobc;

    @Inject
    @RestClient
    LoginBC loginBC;

    @POST
    @Path("/create")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario createBFF(@FormParam("login") String login,
                                @FormParam("password") String password,
                                @FormParam("email") String email){
        return usuariobc.create(login, password, email);
    }

    @GET
    @Path("/list")
    @RolesAllowed("Admin")
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

    @POST
    @Path("/login")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser2BFF(@FormParam("id") Long id, 
                                @FormParam("login") String login, 
                                @FormParam("password") String password){
        
        
        if (usuariobc.getUser(id).getLogin().equals(login) && usuariobc.getUser(id).getPassword().equals(password)){
            return loginBC.getJWT(usuariobc.getUser(id).getLogin(), usuariobc.getUser(id).getEmail());
        }

        throw new BadRequestException("Usuario e Senha incorretos");
        
        
    }

    
}
