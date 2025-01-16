package com.example.IMDbExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MoviesController {

    @Autowired
    MoviesRepository repository;

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }

    @GetMapping("/searchimdb")
    public String searchIMBD(){
        return "search";
    }

    @ResponseBody
    @GetMapping("/search")
    public String searchFilm(@RequestParam(value = "id") String id){
       Optional<Movies> movieResult = repository.findById(id);
        Movies movie = movieResult.orElse(null);
        return String.valueOf(movie.getTconst());
    }

}
