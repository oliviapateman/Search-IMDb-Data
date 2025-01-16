package com.example.IMDbExercise;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movies {

    @Id
    String titleType;
    String primaryTitle;
    boolean isAdult;

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

    public Movies(String titleType, String primaryTitle, boolean isAdult){
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
