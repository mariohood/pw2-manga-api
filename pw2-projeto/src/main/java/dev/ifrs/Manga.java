package dev.ifrs;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    private Long id;

    public Manga(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static List<Manga> listAll() {
        List<Manga> list = new ArrayList<>();
        list.add(new Manga(1234L));
        list.add(new Manga(5678L));
        return list;
    }
    
}
