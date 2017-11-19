package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.DesktopProduct;

import java.util.List;

/**
 * Created by android on 2017-10-27.
 */

public interface DesktopDAO {

    public boolean register(DesktopProduct desktop);

    public List<DesktopProduct> selectAll();
    public DesktopProduct updateProdect(DesktopProduct product,int id,int productNum);
}
