package org.lessons.bestOfTheYear.models;

public class Movie {
    private int id;
    private String titolo;

    public Movie(int id, String titolo) {
        this.id = id;
        this.titolo = titolo;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }
}
