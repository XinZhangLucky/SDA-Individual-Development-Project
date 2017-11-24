package com.example.android.computerstoreapp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.adapter.ProductAdapter;
import com.example.android.computerstoreapp.entity.Product;

import java.util.List;

public class CPUView extends BaseActivityView {

    private ProductAdapter adapter;
    private List<? extends Product> mCPUList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_cpu_main);
        super.onCreate(savedInstanceState);
    }

}
