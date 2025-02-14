package com.example.IMDbExercise;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@Entity
public class Movies {

    @Id
    int tconst;

    String titleType;
    @Lob
    String primaryTitle;
    @Lob
    String originalTitle;
    @Nullable
    boolean isAdult;

    public int getTconst() {
        return tconst;
    }

    public void setTconst(int tconst) {
        this.tconst = tconst;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    protected Movies(){}

    public Movies(int tconst, String titleType, String primaryTitle, String originalTitle){
        this.tconst = tconst;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
    }
}
