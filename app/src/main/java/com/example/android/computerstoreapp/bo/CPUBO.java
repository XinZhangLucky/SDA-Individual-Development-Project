package com.example.android.computerstoreapp.bo;

import com.example.android.computerstoreapp.dao.impl.DesktopDAOInternal;
import com.example.android.computerstoreapp.entity.DesktopProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017-11-09.
 */

public class CPUBO {
    private List<DesktopProduct> mDesktopProductArrayList;
    private DesktopDAOInternal mDesktopDAO;


    public CPUBO() {
        mDesktopProductArrayList = new ArrayList<>();
        mDesktopDAO=new DesktopDAOInternal();
    }

    public DesktopProduct createDesktopProduct(String detail, String name, int cost, int imageId,int num,int id){
        ArrayList<Object> ls =new ArrayList<>();
        ls.add(detail);
        ls.add(name);
        ls.add(cost);
        ls.add(imageId);
        ls.add(num);
        ls.add(id);
        DesktopProduct desktopProduct =new DesktopProduct(ls);
        mDesktopDAO.register(desktopProduct);
        return desktopProduct;
    }

    public DesktopProduct updateDesktopProduct(DesktopProduct product,int id,int productNum){

        return  mDesktopDAO.updateProdect(product,id,productNum);
    }

    public List<DesktopProduct> getDesktopProductArrayList(){
        return mDesktopDAO.selectAll();
    }


}
