package com.example.android.computerstoreapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.bo.ShopCartBO;
import com.example.android.computerstoreapp.entity.Product;
import com.example.android.computerstoreapp.entity.ShopCartProduct;

import java.util.List;

public class ShopcartAdapter extends RecyclerView.Adapter<ShopcartAdapter.ViewHolder> {
    private ViewGroup mParent;
    private List<ShopCartProduct> mProductList;
    private ShopCartBO mShopCartBO;

    public void setProductList(List<ShopCartProduct> productList) {
        mProductList = productList;
    }

    public ShopcartAdapter(List<ShopCartProduct> productList) {
        mProductList = productList;
        mShopCartBO = new ShopCartBO();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View productView;
        LinearLayout productLayout;
        ImageView productImage;
        TextView productName;
        TextView productCost;
        TextView productStock;
        EditText productNum;

        public ViewHolder(View itemView) {
            super(itemView);
            productView = itemView;
            productLayout = (LinearLayout) itemView.findViewById(R.id.shopcart_item_layout);
            productImage = (ImageView) itemView.findViewById(R.id.shopcart_product_image);
            productName = (TextView) itemView.findViewById(R.id.shopcart_product_name);
            productCost = (TextView) itemView.findViewById(R.id.shopcart_product_cost);
            productStock = (TextView) itemView.findViewById(R.id.shopcart_product_stock);
            productNum = (EditText) itemView.findViewById(R.id.shopcart_product_num);
        }
    }

    @Override
    public ShopcartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopcart_item, parent, false);
        mParent = parent;
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ShopcartAdapter.ViewHolder holder, int position) {
        final Product product = mProductList.get(position).getProduct();
        holder.productImage.setImageResource(product.getImageId());
        holder.productNum.setText(String.valueOf(mProductList.get(position).getNum()));
        holder.productNum.setTag(position);
        if (product.getNum() > 0) {
            holder.productStock.setText("In Stock");
        } else {
            holder.productStock.setText("Out Stock");
        }
        holder.productName.setText(product.getName());
        holder.productCost.setText(String.valueOf(product.getCost()) + "Kr");
        holder.productNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    int mPosition = Integer.parseInt(holder.productNum.getTag().toString());
                    int modifyNum = Integer.parseInt(((EditText) v).getText().toString());
                    int initNum = mProductList.get(mPosition).getNum();
                    if (modifyNum == initNum) {
                        return;
                    }
                    mShopCartBO.modifyShopCart(mPosition, modifyNum - initNum, modifyNum);
                    GridLayout gridLayout = (GridLayout) mParent.getParent();
                    LinearLayout linearLayout = (LinearLayout) gridLayout.getChildAt(2);
                    TextView totalTextView = (TextView) linearLayout.getChildAt(1);
                    totalTextView.setText(mShopCartBO.getTotal(mProductList) + "Kr");
                }
            }
        });
        holder.productLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                holder.productLayout.setFocusable(true);
                holder.productLayout.setFocusableInTouchMode(true);
                holder.productLayout.requestFocus();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

}
