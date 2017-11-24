package com.example.android.computerstoreapp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.adapter.CategoryAdapter;
import com.example.android.computerstoreapp.entity.Category;
import com.example.android.computerstoreapp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class HomePageView extends BaseActivityView {

    private List<Category> mCategoryList = new ArrayList<>();
    private final static String KeyboardClassName = "KeyboardView";
    private final static String CPUClassName = "CPUView";
    private final static String MonitorClassName = "MonitorView";
    private final static String NotebookClassName = "NotebookView";
    private final static String DesktopClassName = "DesktopView";
    private final static String AudiocardClassName = "AudiocardView";
    private final static String HarddiskClassName = "HarddiskView";
    private final static String MouseClassName = "MouseView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home_page);
        initCategoryList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        CategoryAdapter adapter = new CategoryAdapter(mCategoryList);
        recyclerView.setAdapter(adapter);
        super.onCreate(savedInstanceState);
    }

    private void initCategoryList() {
        mCategoryList.add(new Category("DesktopView", R.drawable.desktop_home_pic, DesktopClassName));
        mCategoryList.add(new Category("NotebookView", R.drawable.notebook_home_pic, NotebookClassName));
        mCategoryList.add(new Category("CPUView", R.drawable.cpu, CPUClassName));
        mCategoryList.add(new Category("MonitorView", R.drawable.screen, MonitorClassName));
        mCategoryList.add(new Category("KeyboardView", R.drawable.keyboard, KeyboardClassName));
        mCategoryList.add(new Category("AudiocardView", R.drawable.audiocard, AudiocardClassName));
        mCategoryList.add(new Category("HarddiskView", R.drawable.harddisk, HarddiskClassName));
        mCategoryList.add(new Category("MouseView", R.drawable.mouse, MouseClassName));
    }
}
