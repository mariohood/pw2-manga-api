package dev.ifrs.model;

import java.util.List;

public class Anuncio {

    private Long id;
    private Manga manga;
    private String aval;
    private String msgs;
    private List<Mensagem> mensagens;
    
    public Anuncio(Long id, Manga manga, String aval, String msgs, List<Mensagem> mensagens) {
        this.id = id;
        this.manga = manga;
        this.aval = aval;
        this.msgs = msgs;
        this.mensagens = mensagens;
    }
    public Anuncio() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Manga getManga() {
        return manga;
    }
    public void setManga(Manga manga) {
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
    
    
}
