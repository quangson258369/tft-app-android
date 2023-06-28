package com.example.myapplication.Models;

import android.graphics.Bitmap;

public class Suggestion {

    private Bitmap imgSuggester;
    private String title;

    public Suggestion(){}

    public Suggestion(Bitmap imgSuggester, String title) {
        this.imgSuggester = imgSuggester;
        this.title = title;
    }

    public Bitmap getImgSuggester() {
        return imgSuggester;
    }



    public void setImgSuggester(Bitmap imgSuggester) {
        this.imgSuggester = imgSuggester;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
