package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.ShopCartProduct;

import java.util.List;

public interface ShopcartDAO {
    boolean addShopcartInfo(ShopCartProduct product);

    void increateShopcartInfo(ShopCartProduct product, int id);

    List<ShopCartProduct> selectAllProducts(String email);

    void deleteShopcartInfo(String email);
}
