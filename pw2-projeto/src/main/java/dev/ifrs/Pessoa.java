package dev.ifrs;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    
    private String login;
    private String password;
    private String email;
    private String anuncio;
    private boolean admin = false;



    
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
    public static List<Pessoa> listAll() {
        List<Pessoa> list = new ArrayList<>();
        list.add(new Pessoa("1login", "1password", "1@email.com"));
        list.add(new Pessoa("2login", "2password", "2@email.com"));
        return list;
    }
    public String getAnuncio() {
        return anuncio;
    }
    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
   



    
}
