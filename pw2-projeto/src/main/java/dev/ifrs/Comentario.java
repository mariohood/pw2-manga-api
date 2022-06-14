package dev.ifrs;

public class Comentario {
    private Anuncio anuncio;
    private Pessoa pessoa;
    private String mensagem;
    private String like;
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
    
}
