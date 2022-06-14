package dev.ifrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/p")
public class WService {
    
    @GET
    @Path("/create/{login}/{password}/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa pessoa(@PathParam("login") String login, @PathParam("password") String password, @PathParam("email") String email){
        Pessoa pessoa = new Pessoa(login, password, email);
        System.out.println(pessoa.getLogin());
        return pessoa;
    }
     
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Pessoa> list(){
        return Pessoa.listAll();
    } 
}
 