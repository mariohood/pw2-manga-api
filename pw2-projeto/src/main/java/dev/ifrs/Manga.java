package dev.ifrs;


import javax.persistence.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Manga extends PanacheEntity{
    
    private Long manga_id;
    private String comentarios;
    
    public Manga() {
        
    }


    public Long getManga_id() {
        return manga_id;
    }


    public void setManga_id(Long manga_id) {
        this.manga_id = manga_id;
    }


    public String getComentarios() {
        return comentarios;
    }


    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }




    
    
   
}
