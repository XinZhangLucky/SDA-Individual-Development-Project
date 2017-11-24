package com.example.android.computerstoreapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.bo.MenuBO;

public class BaseActivityView extends AppCompatActivity {
    protected final static String CLASSFOLDNAME = ".view.";
    private final static String SHOPCART = "ShopCart";
    protected MenuBO mMenuBO = new MenuBO();
    protected String mPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPath = getApplicationContext().getPackageName() + CLASSFOLDNAME;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (SHOPCART.equals(item.getTitle())) {
            Intent intent = new Intent(getApplicationContext(), ShopcartListView.class);
            startActivity(intent);
        } else {
            Intent intent = null;
            try {
                String className = mMenuBO.getMenuName(item.getItemId());
                intent = new Intent(getApplicationContext(), Class.forName(mPath + className));
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
