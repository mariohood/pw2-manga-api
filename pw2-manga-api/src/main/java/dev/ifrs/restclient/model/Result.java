package dev.ifrs.restclient.model;

import java.util.List;

public class Result {
    List <Manga> mangas;

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }
}
