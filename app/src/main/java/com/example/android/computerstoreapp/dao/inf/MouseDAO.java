package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.MouseProduct;

import java.util.List;

/**
 * Created by android on 2017-11-09.
 */

public interface MouseDAO {
    public boolean register(MouseProduct desktop);

    public List<MouseProduct> selectAll();
    public MouseProduct updateProdect(MouseProduct product,int id,int productNum);
}
