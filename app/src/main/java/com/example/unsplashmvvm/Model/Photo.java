package com.example.unsplashmvvm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @SerializedName("id")
    private String id;
    @SerializedName("alt_description")
    private String caption;
    @SerializedName("urls")
    private Url urls;

    public Photo(String id, String caption, Url urls) {
        this.id = id;
        this.caption = caption;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public Url getUrls() {
        return urls;
    }
}
