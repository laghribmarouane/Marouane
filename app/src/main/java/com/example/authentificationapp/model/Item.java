package com.example.authentificationapp.model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("imageId")
    public int imageId;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;

    public Item(int imageId, String title, String description) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
