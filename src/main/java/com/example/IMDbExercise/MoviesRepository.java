package com.example.IMDbExercise;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, String> {

    List<Movies> findByPrimaryTitle(String primaryTitle);

    List<Movies> findByGenres(List<String> genres);

}
