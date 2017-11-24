package com.example.android.computerstoreapp.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.android.computerstoreapp.dao.inf.ShopcartDAO;
import com.example.android.computerstoreapp.entity.DesktopProduct;
import com.example.android.computerstoreapp.entity.MouseProduct;
import com.example.android.computerstoreapp.entity.Product;
import com.example.android.computerstoreapp.entity.ShopCartProduct;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ShopcartDAOInternal implements ShopcartDAO {
    private final static String SHOPCARTTABLE = "shopcartproduct";
    private final static String MOUSE = "mouseproduct";
    private final static String DESKTOP = "desktopproduct";

    @Override
    public void deleteShopcartInfo(String email) {
        DataSupport.deleteAll(ShopCartProduct.class, "email = ?", email);
    }

    @Override
    public boolean addShopcartInfo(ShopCartProduct product) {
        return product.save();
    }

    @Override
    public void increateShopcartInfo(ShopCartProduct product, int id) {
        ContentValues values = new ContentValues();
        values.put("num", product.getNum());
        DataSupport.update(ShopCartProduct.class, values, id);
    }

    @Override
    public List<ShopCartProduct> selectAllProducts(String email) {
        List<ShopCartProduct> productList = new ArrayList<>();
        Cursor cursor = DataSupport.findBySQL("SELECT * FROM " + SHOPCARTTABLE + " WHERE email = '" + email + "'");
        while (cursor.moveToNext()) {
            int classid = cursor.getInt(cursor.getColumnIndex("classid"));
            String classtype = cursor.getString(cursor.getColumnIndex("classtype"));
            int num = cursor.getInt(cursor.getColumnIndex("num"));
            Cursor cursorProduct = DataSupport.findBySQL("SELECT * FROM " + classtype + " WHERE id = " + classid);
            Product product = null;
            while (cursorProduct.moveToNext()) {
                ArrayList<Object> ls = new ArrayList<>();
                int cost = cursorProduct.getInt(cursorProduct.getColumnIndex("cost"));
                String detail = cursorProduct.getString(cursorProduct.getColumnIndex("detail"));
                String name = cursorProduct.getString(cursorProduct.getColumnIndex("name"));
                int productid = cursorProduct.getInt(cursorProduct.getColumnIndex("productid"));
                int productNum = cursorProduct.getInt(cursorProduct.getColumnIndex("num"));
                int imageId = cursorProduct.getInt(cursorProduct.getColumnIndex("imageid"));
                ls.add(detail);
                ls.add(name);
                ls.add(cost);
                ls.add(imageId);
                ls.add(productNum);
                ls.add(productid);
                if (DESKTOP.equals(classtype)) {
                    product = new DesktopProduct(ls);
                } else if (MOUSE.equals(classtype)) {
                    product = new MouseProduct(ls);
                    int type = cursorProduct.getInt(cursorProduct.getColumnIndex("wireless"));
                    if (type == 0) {
                        ((MouseProduct) product).setWireless(false);
                    } else {
                        ((MouseProduct) product).setWireless(true);
                    }
                }
            }
            productList.add(new ShopCartProduct(product, classid, classtype, num, email));
        }
        return productList;
    }
}
