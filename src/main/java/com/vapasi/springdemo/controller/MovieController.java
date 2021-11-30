package com.vapasi.springdemo.controller;

import com.vapasi.springdemo.dto.MovieDto;
import com.vapasi.springdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/message")
    public String message() {
        return "<H1>My Springboot App</H1>";
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieDto>> getMovies(){
        List<MovieDto> movies = movieService.getMovies();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Integer id){
        Optional<MovieDto> movie = movieService.getMovieById(id);
        if(movie.isPresent())
            return ResponseEntity.ok().body(movie.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto movie){
        MovieDto savedMovie = movieService.saveMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("/actor")
    public ResponseEntity<MovieDto> getMovieByActor(@RequestParam(name = "actorName") String actorName){
        Optional<MovieDto> movie = movieService.getMovieByActorName(actorName);
        if(movie.isPresent())
            return ResponseEntity.ok().body(movie.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/actors")
    public ResponseEntity<List<MovieDto>> getMovieByActors(@RequestParam(name = "actorsName") List<String> actorsName){
        List<MovieDto> movie = movieService.getMovieByActorsName(actorsName);
            return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Integer id, @RequestBody MovieDto movie){
        MovieDto updatedMovie = movieService.updateMovie(id, movie);
        if(updatedMovie == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedMovie);
    }
}
