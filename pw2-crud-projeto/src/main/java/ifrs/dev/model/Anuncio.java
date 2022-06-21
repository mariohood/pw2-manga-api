package ifrs.dev.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Anuncio extends PanacheEntity {

    private String manga;
    private String aval;
    private String msgs;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Mensagem> mensagens;
    
    public Anuncio() {
    }
    public String getManga() {
        return manga;
    }
    public void setManga(String manga) {
        this.manga = manga;
    }
    public String getAval() {
        return aval;
    }
    public void setAval(String aval) {
        this.aval = aval;
    }
    public String getMsgs() {
        return msgs;
    }
    public void setMsgs(String msgs) {
        this.msgs = msgs;
    }
    public List<Mensagem> getMensagens() {
        return mensagens;
    }
    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }
    public void addMensagem(Mensagem msg){
        this.mensagens.add(msg);
    }
    
}
