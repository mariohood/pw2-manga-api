package dev.ifrs;



import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Manga extends PanacheEntity {
    private Long pessoa_id;
    private String texto;
    private String like;

    public Manga() {
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Long getPessoa_id() {
        return pessoa_id;
    }
    public void setPessoa_id(Long pessoa_id) {
        this.pessoa_id = pessoa_id;
    }
    public String getLike() {
        return like;
    }
    public void setLike(String like) {
        this.like = like;
    }
    
}
