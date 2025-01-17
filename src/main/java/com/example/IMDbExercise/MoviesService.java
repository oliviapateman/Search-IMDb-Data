package com.example.IMDbExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    MoviesRepository moviesRepository;

    List<Movies> listAllMovies;

    public Iterable<Movies> listAll(String keyword){
        if (keyword != null){
            return moviesRepository.findAll(keyword);
        }
        return moviesRepository.findAll();
    }
}
