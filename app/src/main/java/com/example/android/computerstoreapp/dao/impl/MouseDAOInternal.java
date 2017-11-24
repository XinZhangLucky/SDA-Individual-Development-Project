package com.example.android.computerstoreapp.dao.impl;

import android.content.ContentValues;

import com.example.android.computerstoreapp.dao.inf.MouseDAO;
import com.example.android.computerstoreapp.entity.MouseProduct;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MouseDAOInternal implements MouseDAO {

    @Override
    public boolean register(MouseProduct mouseProduct) {
        return mouseProduct.save();
    }

    @Override
    public List<MouseProduct> selectAll() {
        List<MouseProduct> mouseProductList = DataSupport.findAll(MouseProduct.class);
        return mouseProductList;
    }

    @Override
    public MouseProduct updateProdect(MouseProduct product, int id, int productNum) {
        ContentValues values = new ContentValues();
        values.put("num", productNum);
        DataSupport.update(MouseProduct.class, values, id);
        product.setNum(productNum);
        return (MouseProduct) product;
    }
}
