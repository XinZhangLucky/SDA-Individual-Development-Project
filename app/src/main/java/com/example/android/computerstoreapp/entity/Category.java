package com.example.android.computerstoreapp.entity;

/**
 * Created by android on 2017-10-26.
 */

public class Category {
    private String name;

    private int imageId;

    private String className;

    public Category(String name, int imageId, String className) {
        this.name = name;
        this.imageId = imageId;
        this.className=className;
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
