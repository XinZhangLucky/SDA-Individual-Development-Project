package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.DesktopProduct;
import com.example.android.computerstoreapp.entity.Product;

import java.util.List;

/**
 * Created by android on 2017-10-27.
 */

public interface ProductDAO {
    public boolean register(Product desktop);

    public List<DesktopProduct> selectAll();
}
