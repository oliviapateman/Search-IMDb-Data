package com.example.IMDbExercise;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Movies {

    @Id
    String titleId;
    String primaryTitle;
    List<String> genres;

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    protected Movies(){}

    public Movies(String titleId, String primaryTitle, List<String> genres){
        this.titleId = titleId;
        this.primaryTitle = primaryTitle;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return String.format("Movies[primaryTitle='%s', genres='%s']",
                primaryTitle, genres);
    }
}
