package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.DesktopProduct;

import java.util.List;

public interface DesktopDAO {
    public boolean register(DesktopProduct desktop);

    public List<DesktopProduct> selectAll();

    public DesktopProduct updateProdect(DesktopProduct product, int id, int productNum);
}
