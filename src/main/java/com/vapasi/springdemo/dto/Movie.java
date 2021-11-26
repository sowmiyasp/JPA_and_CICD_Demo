package com.vapasi.springdemo.dto;

public class Movie {

    private Integer id;
    private String movie;
    private String director;

    public Movie(Integer id, String movie, String director) {
        this.id = id;
        this.movie = movie;
        this.director = director;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getMovie() {
        return movie;
    }

    public String getDirector() {
        return director;
    }
}
