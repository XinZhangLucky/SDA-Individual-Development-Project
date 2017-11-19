package com.example.android.computerstoreapp.entity;

import java.util.ArrayList;

/**
 * Created by android on 2017-11-09.
 */

public class MouseProduct extends Product {
    private boolean wireless;

    public MouseProduct() {
    }

    public MouseProduct(ArrayList<Object> prams) {
        super(prams);

    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }
}
