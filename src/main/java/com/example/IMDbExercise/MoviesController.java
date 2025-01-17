package com.example.IMDbExercise;

import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    MoviesRepository repository;

    @Autowired
    MoviesService moviesService;

    @RequestMapping("/searchimdb")
    public String viewSearchPage(Model model, @Param("keyword") String keyword) {
        List<Movies> listMovies = moviesService.listAll(keyword);
        model.addAttribute("listMovies", listMovies);
        model.addAttribute("keyword", keyword);
        return "searchimdb";
    }

}