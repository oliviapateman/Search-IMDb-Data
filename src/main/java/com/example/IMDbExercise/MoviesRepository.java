package com.example.IMDbExercise;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    @Query("SELECT m FROM Movies m WHERE CONCAT(m.primaryTitle, m.originalTitle) LIKE %?1%")
    public List<Movies> search(String keyword);

}
