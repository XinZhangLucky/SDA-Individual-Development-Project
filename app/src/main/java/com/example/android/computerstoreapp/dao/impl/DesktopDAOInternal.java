package com.example.android.computerstoreapp.dao.impl;

import android.content.ContentValues;

import com.example.android.computerstoreapp.dao.inf.DesktopDAO;
import com.example.android.computerstoreapp.entity.DesktopProduct;

import org.litepal.crud.DataSupport;

import java.util.List;

public class DesktopDAOInternal implements DesktopDAO {

    @Override
    public boolean register(DesktopProduct desktop) {
        return desktop.save();
    }

    @Override
    public List<DesktopProduct> selectAll() {
        List<DesktopProduct> desktopProductList = DataSupport.findAll(DesktopProduct.class);
        return desktopProductList;
    }

    public DesktopProduct updateProdect(DesktopProduct product, int id, int productNum) {
        ContentValues values = new ContentValues();
        values.put("num", productNum);
        DataSupport.update(DesktopProduct.class, values, id);
        product.setNum(productNum);
        return (DesktopProduct) product;

    }


}
