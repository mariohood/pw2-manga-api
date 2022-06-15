package dev.ifrs;

import java.util.ArrayList;
import java.util.List;

public class Comentario {
    private Anuncio anuncio;
    private Pessoa pessoa;
    private String mensagem;
    private String like;

    
    public Comentario(Anuncio anuncio, Pessoa pessoa, String mensagem) {
        this.anuncio = anuncio;
        this.pessoa = pessoa;
        this.mensagem = mensagem;
    }
    public Anuncio getAnuncio() {
        return anuncio;
    }
    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getLike() {
        return like;
    }
    public void setLike(String like) {
        this.like = like;
    }
    public static List<Comentario> listAll() {
        List<Comentario> list = new ArrayList<>();
        list.add(new Comentario(new Anuncio(new Pessoa("1pessoa_Coment"), new Manga(1234L)), new Pessoa("1pessoa_Coment"), "mensagem1"));
        list.add(new Comentario(new Anuncio(new Pessoa("2pessoa_Coment"), new Manga(567L)), new Pessoa("2pessoa_Coment"), "mensagem2"));
        return list;
    }

}
