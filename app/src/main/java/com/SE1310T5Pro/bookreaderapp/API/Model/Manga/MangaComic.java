package com.SE1310T5Pro.bookreaderapp.API.Model.Manga;

import com.SE1310T5Pro.bookreaderapp.API.Model.Genres;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MangaComic {
    @SerializedName("bookID")
    private String bookID;

    @SerializedName("title")
    private String title;

    @SerializedName("thumnailpath")
    private String thumnailpath;

    @SerializedName("ratingvalue")
    private float ratingvalue;

    @SerializedName("ratingcount")
    private float ratingcount;

    @SerializedName("author")
    private String author;

    @SerializedName("detailcontent")
    private String detailcontent;

    @SerializedName("genres")
    public ArrayList<Genres> genres;

    MangaComic(){

    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumnailpath() {
        return thumnailpath;
    }

    public void setThumnailpath(String thumnailpath) {
        this.thumnailpath = thumnailpath;
    }

    public float getRatingvalue() {
        return ratingvalue;
    }

    public void setRatingvalue(float ratingvalue) {
        this.ratingvalue = ratingvalue;
    }

    public float getRatingcount() {
        return ratingcount;
    }

    public void setRatingcount(float ratingcount) {
        this.ratingcount = ratingcount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetailcontent() {
        return detailcontent;
    }

    public void setDetailcontent(String detailcontent) {
        this.detailcontent = detailcontent;
    }

    public MangaComic(ArrayList<Genres> genres) {
        this.genres = genres;
    }

    public void setGenres(ArrayList<Genres> genres) {
        this.genres = genres;
    }
}
