package com.example.android.computerstoreapp.entity;

public class Category {
    private String name;
    private int imageId;
    private String className;

    public Category(String name, int imageId, String className) {
        this.name = name;
        this.imageId = imageId;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getClassName() {
        return className;
    }
}
