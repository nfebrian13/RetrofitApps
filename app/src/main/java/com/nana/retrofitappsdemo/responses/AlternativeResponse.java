package com.nana.retrofitappsdemo.responses;

import com.google.gson.annotations.SerializedName;
import com.nana.retrofitappsdemo.model.Movie;
import com.nana.retrofitappsdemo.model.Titles;

import java.util.List;


public class AlternativeResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("titles")
    private List<Titles> titles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Titles> getTitles() {
        return titles;
    }

    public void setTitles(List<Titles> titles) {
        this.titles = titles;
    }
}
