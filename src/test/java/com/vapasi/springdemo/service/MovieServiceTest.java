package com.vapasi.springdemo.service;

import com.vapasi.springdemo.dto.Movie;
import com.vapasi.springdemo.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    MovieService movieService;
    MovieRepository movieRepository;

    @BeforeEach
    void setUp(){
        movieRepository = mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void shouldReturnAllMoviesInList(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie1", "Director1"));
        movies.add(new Movie(2, "Movie2", "Director2"));
        movies.add(new Movie(3, "Movie3", "Director3"));
        when(movieRepository.getMovies()).thenReturn(movies);

        List<Movie> retrievedMovies = movieService.getMovies();

        verify(movieRepository, times(1)).getMovies();
        assertEquals(movies, retrievedMovies);
    }
}