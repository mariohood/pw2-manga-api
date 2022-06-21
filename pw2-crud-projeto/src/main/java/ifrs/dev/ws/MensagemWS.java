package ifrs.dev.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ifrs.dev.model.Mensagem;

@Path("/mensagem")
public class MensagemWS {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Mensagem create(@FormParam("texto") String texto,
                            @FormParam("user_id") String user_id){
        Mensagem msg = new Mensagem();
        msg.setTexto(texto);
        msg.setUser_id(user_id);
        msg.persistAndFlush();
        return msg;                        
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mensagem> list(){
        return Mensagem.listAll();
    }

    
}
