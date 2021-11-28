package com.vapasi.springdemo.repository;

import com.vapasi.springdemo.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
    Optional<MovieEntity> findByActorName(String actorName);
    Iterable<MovieEntity> findAllByActorNameIn(Iterable<String> actorName);



}
