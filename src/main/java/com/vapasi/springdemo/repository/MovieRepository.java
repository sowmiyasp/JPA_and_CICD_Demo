package com.vapasi.springdemo.repository;

import com.vapasi.springdemo.dto.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class MovieRepository {

    List<Movie> movies = new ArrayList<Movie>(){{
        add(new Movie(101, "Movie 1", "Director 1"));
        add(new Movie(102, "Movie 2", "Director 2"));
        add(new Movie(103, "Movie 3", "Director 3"));
        add(new Movie(104, "Movie 4", "Director 4"));
        add(new Movie(105, "Movie 5", "Director 5"));

    }};

    public List<Movie> getMovies(){
        return movies;
    }

    public Movie saveMovie(Movie movie){
        movie.setId(movies.get(movies.size()-1).getId() + 1);
        movies.add(movie);
        return movie;

    }

    public Movie getMovieById(Integer id) {
        for(Movie movie : movies) {
            if(movie.getId().intValue() == id.intValue())
                return movie;
        }
        return null;
    }

    public boolean deleteMovie(Integer id) {
        Iterator<Movie> moviesItr = movies.iterator();
        while(moviesItr.hasNext()){
            if(moviesItr.next().getId().intValue() == id.intValue()){
                moviesItr.remove();
                return true;
            }
        }
        return false;
    }
}
