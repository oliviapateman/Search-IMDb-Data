package com.example.IMDbExercise;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Movies {

    @Id
    int tconst;

    String titleType;
    @Lob
    String primaryTitle;
    boolean isAdult;

    public int getTconst() {
        return tconst;
    }

    public void setTconst(int tconst) {
        this.tconst = tconst;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
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

    protected Movies(){}

    public Movies(int tconst, String titleType, String primaryTitle, boolean isAdult){
        this.tconst = tconst;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.isAdult = isAdult;
    }

    @Override
    public String toString() {
        return String.format("[titleType='%s', primaryTitle='%s', isAdult='%s']",
                titleType, primaryTitle, isAdult);
    }
}
