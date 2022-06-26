package dev.ifrs.model;

public class Mensagem {
    private Long id;
    private String texto;
    private String user_id;
    public Mensagem(Long id, String texto, String user_id) {
        this.id = id;
        this.texto = texto;
        this.user_id = user_id;
    }
    public Mensagem() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
}
