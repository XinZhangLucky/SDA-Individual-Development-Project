package com.example.android.computerstoreapp.bo;

import com.example.android.computerstoreapp.dao.impl.MouseDAOInternal;
import com.example.android.computerstoreapp.dao.inf.MouseDAO;
import com.example.android.computerstoreapp.entity.MouseProduct;

import java.util.ArrayList;
import java.util.List;

public class MouseBO {
    private List<MouseProduct> mMouseProductArrayList;
    private MouseDAO mMouseDAO;

    public MouseBO() {
        mMouseProductArrayList = new ArrayList<>();
        mMouseDAO = new MouseDAOInternal();
    }

    public MouseProduct createMouseProduct(String detail, String name, int cost, int imageId, int num, int id, boolean wireless) {
        ArrayList<Object> ls = new ArrayList<>();
        ls.add(detail);
        ls.add(name);
        ls.add(cost);
        ls.add(imageId);
        ls.add(num);
        ls.add(id);
        MouseProduct mouseProduct = new MouseProduct(ls);
        mouseProduct.setWireless(wireless);
        mMouseDAO.register(mouseProduct);
        return mouseProduct;
    }

    public MouseProduct updateMouseProduct(MouseProduct product, int id, int productNum) {
        return mMouseDAO.updateProdect(product, id, productNum);
    }

    public List<MouseProduct> getMouseProductArrayList() {
        return mMouseDAO.selectAll();
    }


}
