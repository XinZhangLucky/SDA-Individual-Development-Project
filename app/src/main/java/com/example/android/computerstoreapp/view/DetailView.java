package com.example.android.computerstoreapp.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.bo.ShopCartBO;
import com.example.android.computerstoreapp.entity.MouseProduct;
import com.example.android.computerstoreapp.entity.Product;

public class DetailView extends BaseActivityView {
    private ImageView image;
    private TextView title;
    private TextView cost;
    private TextView detail;
    private TextView stock;
    private TextView num;
    private int productId;
    private ImageButton shopcartBtn;
    private ShopCartBO mShopCartBO;
    private Product mProduct;
    protected String mPath;
    protected static String classFoldName = ".view.";
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_detail);
        mShopCartBO = new ShopCartBO();
        image = (ImageView) findViewById(R.id.detail_imageView);
        title = (TextView) findViewById(R.id.detail_title);
        cost = (TextView) findViewById(R.id.detail_cost);
        detail = (TextView) findViewById(R.id.detail_item);
        stock = (TextView) findViewById(R.id.detail_stock);
        shopcartBtn = (ImageButton) findViewById(R.id.detail_addShopCart);
        num = (TextView) findViewById(R.id.detail_num);
        mProduct = (Product) getIntent().getSerializableExtra("product");
        productId = getIntent().getIntExtra("id", 0);
        image.setImageResource(mProduct.getImageId());
        title.setText(mProduct.getName());
        cost.setText(mProduct.getCost() + "Kr");
        if (mProduct instanceof MouseProduct) {
            MouseProduct mouseProduct = (MouseProduct) mProduct;
            String mouseDetail = "";
            if (mouseProduct.isWireless()) {
                mouseDetail = "Wired Mouse" + System.getProperty("line.separator");
            } else {
                mouseDetail = "Wireless Mouse" + System.getProperty("line.separator");
            }
            detail.setText(mouseDetail + mProduct.getDetail());
        } else {
            detail.setText(mProduct.getDetail());
        }
        setStockStatus();
        mPath = getApplicationContext().getPackageName() + classFoldName;
        SharedPreferences sharedPreferences = getSharedPreferences("user",
                Activity.MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void addProductToShopCart(View view) {
        mProduct = mShopCartBO.addShopCart(mProduct, productId, email);
        setStockStatus();
        Toast.makeText(this, "add to shop cart", Toast.LENGTH_SHORT).show();
    }

    private void setStockStatus() {
        if (mProduct != null) {
            if (mProduct.getNum() > 0) {
                stock.setText("In Stock");
                num.setText(mProduct.getNum() + " Kvar");
                num.setVisibility(View.VISIBLE);
                shopcartBtn.setEnabled(true);
                shopcartBtn.setBackgroundColor(Color.WHITE);

            } else {
                stock.setText("Out of Stock");
                shopcartBtn.setEnabled(false);
                num.setVisibility(View.GONE);
                shopcartBtn.setBackgroundColor(Color.GRAY);
            }
        }
    }
}
