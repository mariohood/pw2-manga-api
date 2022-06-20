package dev.ifrs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pessoa extends PanacheEntity{
       
    private String login;
    private String password;
    private String email;
    private boolean admin = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa_id")
    private List<Anuncio> anuncios;

    public Pessoa() {
    }
    public Pessoa(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public List<Anuncio> getAnuncios() {
        return anuncios;
    }
    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
    public void addAnuncio(Anuncio anuncio) {
        this.anuncios.add(anuncio);
        
    }

}
