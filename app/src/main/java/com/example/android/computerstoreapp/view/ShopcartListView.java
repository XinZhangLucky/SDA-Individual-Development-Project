package com.example.android.computerstoreapp.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.adapter.ShopcartAdapter;
import com.example.android.computerstoreapp.bo.ShopCartBO;
import com.example.android.computerstoreapp.entity.ShopCartProduct;

import java.util.List;


public class ShopcartListView extends BaseActivityView {

    private ShopcartAdapter adapter;
    private ShopCartBO mShopCartBO = new ShopCartBO();
    private List<ShopCartProduct> mShopcartList;
    private Button submitBtn ;
    private TextView totalTextView;
    private TextView noProductInfoTextView;
    private TextView totalTitleTextView;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_shopcart_main);
        SharedPreferences sharedPreferences= getSharedPreferences("user",
                Activity.MODE_PRIVATE);

        email =sharedPreferences.getString("email", "");
        mShopcartList=mShopCartBO.selectAllProducts(email);
        submitBtn=(Button)findViewById(R.id.shopcart_submit);
        noProductInfoTextView=(TextView)findViewById(R.id.shopcart_noproduct_info);
        totalTextView=(TextView)findViewById(R.id.shopcart_total);
        totalTitleTextView=(TextView)findViewById(R.id.shopcart_total_title);
        if (mShopcartList.size()>0){
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_shopcart_main);

            GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),
                    1,
                    LinearLayoutManager.VERTICAL,
                    false);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new ShopcartAdapter(mShopcartList);
            recyclerView.setAdapter(adapter);


            totalTextView.setText(mShopCartBO.getTotal(mShopcartList) + "Kr");
            totalTextView.setVisibility(View.VISIBLE);
            totalTitleTextView.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);
            noProductInfoTextView.setVisibility(View.GONE);
        }else{
            submitBtn.setVisibility(View.GONE);
            totalTextView.setVisibility(View.GONE);
            totalTitleTextView.setVisibility(View.GONE);
            noProductInfoTextView.setVisibility(View.VISIBLE);

        }

        super.onCreate(savedInstanceState);
    }

    public void submitOrder(View view){

        Intent intent = new Intent(this,SubmitOrderView.class);
        intent.putExtra("num",mShopcartList.size());
        for(int i=0;i<mShopcartList.size();i++){
            intent.putExtra("shopcart" + i,  mShopcartList.get(i));
        }
        startActivity(intent);

    }

}
