package ifrs.dev.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Manga extends PanacheEntity{

    private String mal_id;

    public Manga() {
    }

    public String getMal_id() {
        return mal_id;
    }

    public void setMal_id(String mal_id) {
        this.mal_id = mal_id;
    }

   
    
}
