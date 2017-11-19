package com.example.android.computerstoreapp.entity;

import java.util.ArrayList;

/**
 * Created by android on 2017-10-24.
 */

public class DesktopProduct extends Product {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DesktopProduct(){}

    public DesktopProduct(ArrayList<Object> prams) {
        super(prams);
    }


}
