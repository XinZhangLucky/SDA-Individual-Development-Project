package com.example.android.computerstoreapp.entity;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by android on 2017-10-30.
 */

public class ShopCartProduct extends DataSupport implements Serializable {


    private Product product;
    private int classId;
    private String classType;
    private int num;
    private String email;

    public ShopCartProduct(Product product, int id, String classType, int num,String email) {
        this.product = product;
        this.classId = id;
        this.classType = classType;
        this.num = num;
        this.email =email;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getclassId() {
        return classId;
    }

    public void setclassId(int id) {
        this.classId = id;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product Name : " + product.getName() + System.getProperty("line.separator") +
                "Number : " +num +System.getProperty("line.separator") +
                "Cost : " + (product.getCost() * num) + System.getProperty("line.separator");
    }
}
