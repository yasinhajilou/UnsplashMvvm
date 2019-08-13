package com.example.unsplashmvvm.Model;

import com.google.gson.annotations.SerializedName;

public class Url {
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("full")
    private String full;

    public Url(String thumb, String full) {
        this.thumb = thumb;
        this.full = full;
    }

    public String getThumb() {
        return thumb;
    }

    public String getFull() {
        return full;
    }
}
