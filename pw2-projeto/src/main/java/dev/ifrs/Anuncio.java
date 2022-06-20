package dev.ifrs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Anuncio extends PanacheEntity{
    
    
    private String estrelas;
    private String status;
   
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "anuncio_id")
    private List<Manga> mangas;

    

    public Anuncio() {
        
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


    public List<Manga> getMangas() {
        return mangas;
    }


    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }
    
    public void addMangas(Manga manga){
        this.mangas.add(manga);
    }
    

}
