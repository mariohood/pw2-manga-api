package dev.ifrs;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Anuncio extends PanacheEntity{
    
    
    private String estrelas;
    private String status;
    
  
    private String mangas;
    
    
    
    public Anuncio() {        
        this.status = "Válido";
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

    public String getMangas() {
        return mangas;
    }

    public void setMangas(String mangas) {
        this.mangas = mangas;
    }

    
    }
