package com.example.androidjapanesequizapp.Model;

public class SubjectCategory {
    private String Name;
    private String Image;

    public SubjectCategory() {
    }

    public SubjectCategory(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
