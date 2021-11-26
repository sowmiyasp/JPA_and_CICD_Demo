package com.vapasi.springdemo.service;

import com.vapasi.springdemo.dto.Movie;
import com.vapasi.springdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.getMovies();
    }

    public Movie getMovieById(Integer id) {

        return movieRepository.getMovieById(id);
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.saveMovie(movie);
    }


    public boolean deleteMovie(Integer id) {
        return movieRepository.deleteMovie(id);
    }
}
