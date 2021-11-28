package com.vapasi.springdemo.entities;

import com.vapasi.springdemo.dto.MovieDto;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String movieName;
    private String actorName;
    private String directorName;

    public MovieEntity(Integer id, String movieName, String actorName, String directorName) {
        this.id = id;
        this.movieName = movieName;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public MovieEntity(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
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

    public static MovieEntity toEntity(MovieDto movieDto){
        return new MovieEntity(movieDto.getId(), movieDto.getMovieName(), movieDto.getActorName(), movieDto.getDirectorName());
    }
}

