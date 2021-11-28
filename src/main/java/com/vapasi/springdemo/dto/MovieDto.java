package com.vapasi.springdemo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.vapasi.springdemo.entities.MovieEntity;


public class MovieDto {

    private Integer id;
    private String movieName;
    private String actorName;
    private String directorName;

    public MovieDto(Integer id, String movieName, String actorName, String directorName) {
        this.id = id;
        this.movieName = movieName;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public static MovieDto toDto(MovieEntity movieEntity){
        return new MovieDto(movieEntity.getId(),
                movieEntity.getMovieName(),
                movieEntity.getActorName(),
                movieEntity.getDirectorName());
    }
}
