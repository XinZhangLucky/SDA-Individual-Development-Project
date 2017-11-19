package com.example.android.computerstoreapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.computerstoreapp.R;

public class CreatedOrder extends BaseActivityView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        Button btn = (Button)findViewById(R.id.goback_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        CreatedOrder.this,
                        HomePageView.class);
                startActivity(intent);
            }
        });
    }
}
