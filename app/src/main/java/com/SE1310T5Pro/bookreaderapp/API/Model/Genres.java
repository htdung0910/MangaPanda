package com.SE1310T5Pro.bookreaderapp.API.Model;

import com.google.gson.annotations.SerializedName;

public class Genres {
    @SerializedName("genreID")
    int genreID;
    @SerializedName("genre")
    String genre;

    public Genres() {
    }

    public Genres(int genreID, String genre) {
        this.genreID = genreID;
        this.genre = genre;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
