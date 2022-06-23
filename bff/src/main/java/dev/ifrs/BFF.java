package dev.ifrs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/bff")
public class BFF {
    
    @Inject
    @RestClient
    BackendClient backend;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listBFF(){
        return backend.list();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserBFF(@PathParam("id") Long id){
        return backend.getUser(id);
    }
}
