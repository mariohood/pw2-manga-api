package dev.ifrs;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Comentario extends PanacheEntity{
    
    
    private String pessoa_id;
    private String mensagem;
    private String like;
    
    public Comentario() {        
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

    public String getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(String pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    
}
