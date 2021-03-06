package com.example.android.computerstoreapp.entity;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;

public class Product extends DataSupport implements Serializable {
    protected String detail;
    protected String name;
    protected int cost;
    protected int imageId;
    protected int num;
    protected int productId;

    public Product() {
    }

    public Product(ArrayList<Object> prams) {
        this.detail = (String) prams.get(0);
        this.name = (String) prams.get(1);
        this.cost = (Integer) prams.get(2);
        this.imageId = (Integer) prams.get(3);
        this.num = (Integer) prams.get(4);
        this.productId = (Integer) prams.get(5);
    }

    public int getProductId() {
        return productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

}
