package com.nana.retrofitappsdemo.model;

import com.google.gson.annotations.SerializedName;

public class Titles {

    @SerializedName("iso_3166_1")
    private String iso_3166_1;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    public Titles(String iso_3166_1, String title, String type) {
        this.iso_3166_1 = iso_3166_1;
        this.title = title;
        this.type = type;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
