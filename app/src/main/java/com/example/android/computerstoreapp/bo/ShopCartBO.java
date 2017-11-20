package com.example.android.computerstoreapp.bo;

import com.example.android.computerstoreapp.dao.impl.ShopcartDAOInternal;
import com.example.android.computerstoreapp.dao.inf.ShopcartDAO;
import com.example.android.computerstoreapp.entity.DesktopProduct;
import com.example.android.computerstoreapp.entity.MouseProduct;
import com.example.android.computerstoreapp.entity.Product;
import com.example.android.computerstoreapp.entity.ShopCartProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017-10-30.
 */

public class ShopCartBO {

    private ShopcartDAO mShopcartDAO;
    private final static String DESKTOPPRODUCT = "desktopproduct";
    private final static String MOUSEPRODUCT = "mouseproduct";
    protected static List<ShopCartProduct> mProducts = new ArrayList<>();

    private MouseBO mMouseBO;
    private DesktopBO mDesktopBO;

    public ShopCartBO() {
        mShopcartDAO =new ShopcartDAOInternal();
        //mProducts=new ArrayList<>();
        mDesktopBO = new DesktopBO();
        mMouseBO = new MouseBO();
    }

    public Product addShopCart(Product product,int id, String email){

        if(mProducts.size()==0){
            mProducts= selectAllProducts(email);
        }

        if(product instanceof DesktopProduct) {
            int num = product.getNum()-1;

            product=mDesktopBO.updateDesktopProduct((DesktopProduct)product,id,num);

            addShopcart(product,id,DESKTOPPRODUCT,email);

        }else if(product instanceof MouseProduct){

            int num = product.getNum()-1;

            product=mMouseBO.updateMouseProduct((MouseProduct) product,id,num);

            addShopcart(product,id,MOUSEPRODUCT,email);
        }
        return product;

    }

    public void deleteShopCart(String email){
        mShopcartDAO.deleteShopcartInfo(email);
    }

    public void modifyShopCart( int position , int productNum,int modifyNum){

        ShopCartProduct shopCartProduct = mProducts.get(position);
        shopCartProduct.setNum(modifyNum);
        Product product = shopCartProduct.getProduct();

        if(product instanceof DesktopProduct){

            mDesktopBO.updateDesktopProduct((DesktopProduct)product,
                    product.getProductId(),
                    product.getNum()-productNum);
        }else if(product instanceof MouseProduct){
            mMouseBO.updateMouseProduct((MouseProduct) product,
                    product.getProductId(),
                    product.getNum()-productNum);
        }


        mShopcartDAO.increateShopcartInfo(shopCartProduct,position+1);


    }

    public List<ShopCartProduct> selectAllProducts(String email){

        mProducts= mShopcartDAO.selectAllProducts(email);
        return mProducts;
    }

    private Product addShopcart(Product product,int id,String type,String email){


        for (int i=0;i<mProducts.size();i++){

            ShopCartProduct shopCartProduct = mProducts.get(i);
            Product productStored = mProducts.get(i).getProduct();
            int num = mProducts.get(i).getNum();

            if((product.getClass()== productStored.getClass())&& (product.getProductId()==productStored.getProductId())){

                shopCartProduct.setNum(num+1);

                mShopcartDAO.increateShopcartInfo(shopCartProduct,i+1);

                return product;
            }
        }
        ShopCartProduct mShopCartProduct=new ShopCartProduct(product,id,type,1,email);
        mProducts.add(mShopCartProduct);
        mShopcartDAO.addShopcartInfo(mShopCartProduct);

       return product;
    }

    public int getTotal(List<ShopCartProduct> shopcartList){
        int total =0;
        for (ShopCartProduct shopCartProduct:shopcartList) {
            total = total + (shopCartProduct.getProduct().getCost() * shopCartProduct.getNum());
        }
        return total;
    }

}
