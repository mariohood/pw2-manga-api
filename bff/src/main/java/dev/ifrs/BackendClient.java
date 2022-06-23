package dev.ifrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface BackendClient {

    @GET
    @Path("/usuario/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String list ();

    @GET
    @Path("/usuario/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser (@PathParam("id") Long id);


}
