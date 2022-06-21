package ifrs.dev.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Anuncio extends PanacheEntity {

    private String manga;
    private String aval;
    private String msgs;
    
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
    
}
