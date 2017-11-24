package com.example.android.computerstoreapp.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.entity.Product;
import com.example.android.computerstoreapp.view.DetailView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<? extends Product> mProductList;

    public void setProductList(List<? extends Product> productList) {
        mProductList = productList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View productView;
        ImageView productImage;
        TextView productName;
        TextView productCost;

        public ViewHolder(View view) {
            super(view);
            productView = view;
            productImage = (ImageView) view.findViewById(R.id.product_image);
            productName = (TextView) view.findViewById(R.id.product_name);
            productCost = (TextView) view.findViewById(R.id.product_cost);
        }
    }

    public ProductAdapter(List<? extends Product> productList) {
        mProductList = productList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.productView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Product product = mProductList.get(position);
                Intent intent = new Intent(v.getContext(), DetailView.class);

                intent.putExtra("product", product);
                intent.putExtra("id", position + 1);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.productImage.setImageResource(product.getImageId());
        holder.productName.setText(product.getName());
        holder.productCost.setText(String.valueOf(product.getCost()) + "Kr");
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
}
