package dev.ifrs.model;

public class Manga {
    
   private Long id;
   private String mal_id;
public Manga() {
}
public Manga(Long id, String mal_id) {
    this.id = id;
    this.mal_id = mal_id;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getMal_id() {
    return mal_id;
}
public void setMal_id(String mal_id) {
    this.mal_id = mal_id;
}
   

    
}
