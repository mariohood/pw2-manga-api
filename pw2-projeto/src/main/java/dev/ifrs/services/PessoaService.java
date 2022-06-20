package dev.ifrs.services;

import java.util.List;
import dev.ifrs.*;

import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pessoa")
public class PessoaService {
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Pessoa pessoa(@FormParam("login") String login, 
                            @FormParam("password") String password, 
                            @FormParam("email") String email){
        Pessoa pessoa = new Pessoa();
        pessoa.setLogin(login);
        pessoa.setPassword(password);
        pessoa.setEmail(email);
        pessoa.persist();
        return pessoa;
    }
     
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Pessoa> list(){
        return Pessoa.listAll();
    } 

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa find(@PathParam("id") Long id) {
        return Pessoa.findById(id);
    } 

}

 