package dev.ifrs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.backendclients.MangaBC;
import dev.ifrs.model.Manga;

@Path("/bff/manga")
public class MangaBFF {
    @Inject
    @RestClient
    MangaBC mangabc;

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga createBFF(@FormParam("mal_id") String mal_id){
        return mangabc.create(mal_id);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Manga> listBFF(){
        return mangabc.list();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga getMangaBFF(@PathParam("id") Long id){
        return mangabc.getManga(id);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id){
        mangabc.delete(id);
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Manga update(@PathParam("id") Long id, @FormParam("login") String login,
                            @FormParam("mal_id") String mal_id){
                                return mangabc.update(id, login, mal_id);
                            }
}
