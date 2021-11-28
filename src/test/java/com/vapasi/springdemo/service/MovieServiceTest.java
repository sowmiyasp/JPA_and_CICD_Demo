package com.vapasi.springdemo.service;

import com.vapasi.springdemo.dto.MovieDto;
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

    }
}