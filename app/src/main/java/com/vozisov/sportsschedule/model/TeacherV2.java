package com.vozisov.sportsschedule.model;

import com.google.gson.annotations.SerializedName;

public class TeacherV2 {

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("position")
    private String position;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return
                "TeacherV2{" +
                        "imageUrl = '" + imageUrl + '\'' +
                        ",name = '" + name + '\'' +
                        ",short_name = '" + shortName + '\'' +
                        ",position = '" + position + '\'' +
                        "}";
    }
}