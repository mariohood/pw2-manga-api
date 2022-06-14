package dev.ifrs.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.ifrs.restclient.model.Manga;

@RegisterRestClient(configKey = "restclient-api")
@Produces(MediaType.APPLICATION_JSON)
public interface RestClient {
    @GET
    @Path("/auto-complete")
    Manga search (@HeaderParam("x-rapidapi-key") String xRapidapiKey,
    @HeaderParam("x-rapidapi-host") String xRapidapiHost,
    @QueryParam("q") String query);
}
