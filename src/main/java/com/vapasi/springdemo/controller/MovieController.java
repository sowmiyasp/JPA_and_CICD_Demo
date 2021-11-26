package com.vapasi.springdemo.controller;

import com.vapasi.springdemo.dto.Movie;
import com.vapasi.springdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies = movieService.getMovies();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id){
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping("/")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        Movie savedMovie = movieService.saveMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable Integer id){
        Boolean isDeleted = movieService.deleteMovie(id);
        return ResponseEntity.ok().body(isDeleted);
    }

}
