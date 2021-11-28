package com.vapasi.springdemo.service;

import com.vapasi.springdemo.dto.MovieDto;
import com.vapasi.springdemo.entities.MovieEntity;
import com.vapasi.springdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getMovies(){
        List<MovieDto> movies = new ArrayList<>();
        for(MovieEntity movieEntity : movieRepository.findAll()) {
            movies.add(MovieDto.toDto(movieEntity));
        }
        return movies;
    }

    public Optional<MovieDto> getMovieById(Integer id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        return movieEntity.map(MovieDto::toDto);
    }

    public MovieDto saveMovie(MovieDto movie){
        MovieEntity movieEntity = MovieEntity.toEntity(movie);
        MovieEntity savedEntity = movieRepository.save(movieEntity);
        return MovieDto.toDto(savedEntity);
    }

    public Optional<MovieDto> getMovieByActorName(String actorName) {
        Optional<MovieEntity> movieEntity = movieRepository.findByActorName(actorName);
        return movieEntity.map(MovieDto::toDto);
    }

    public List<MovieDto> getMovieByActorsName(List<String> actorsName) {
        List<MovieDto> movies = new ArrayList<>();
        Iterable<MovieEntity> movieEntities = movieRepository.findAllByActorNameIn(actorsName);
        for(MovieEntity movieEntity : movieEntities)
            movies.add(MovieDto.toDto(movieEntity));
        return movies;
    }

    public MovieDto updateMovie(Integer id,MovieDto movie) {
        MovieEntity movieInUpdateRequest = MovieEntity.toEntity(movie);
        Optional<MovieEntity> optionalMovieEntity = movieRepository.findById(id);
        if(optionalMovieEntity.isPresent()){
            MovieEntity movieEntity = optionalMovieEntity.get();
            movieEntity.setMovieName(movieInUpdateRequest.getMovieName());
            movieEntity.setActorName(movieInUpdateRequest.getActorName());
            movieEntity.setDirectorName(movieInUpdateRequest.getDirectorName());
            movieRepository.save(movieEntity);
            MovieDto updatedMovie = MovieDto.toDto(movieEntity);
            return updatedMovie;
        }
        return null;

    }
}