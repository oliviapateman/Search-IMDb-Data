package com.example.IMDbExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    MoviesRepository moviesRepository;

    public List<Movies> listAll(String keyword){
        if (keyword != null){
            return moviesRepository.search(keyword);
        }
        return Collections.emptyList();
    }

}