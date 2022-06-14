package dev.ifrs;

import java.util.List;

public class Anuncio {
    
    private Pessoa pessoa;
    private Manga manga;
    private List<Comentario> comentarios;
    private String estrelas;
    private String status;
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Manga getManga() {
        return manga;
    }
    public void setManga(Manga manga) {
        this.manga = manga;
    }
    public List<Comentario> getComentarios() {
        return comentarios;
    }
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    public String getEstrelas() {
        return estrelas;
    }
    public void setEstrelas(String estrelas) {
        this.estrelas = estrelas;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
