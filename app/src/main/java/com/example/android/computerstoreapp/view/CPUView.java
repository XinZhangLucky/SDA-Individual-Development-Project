package com.example.android.computerstoreapp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.adapter.ProductAdapter;
import com.example.android.computerstoreapp.bo.CPUBO;
import com.example.android.computerstoreapp.entity.Product;

import java.util.List;

public class CPUView extends BaseActivityView {

    protected CPUBO mCPUBO;

    private ProductAdapter adapter;

    private List<? extends Product> mCPUList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_cpu_main);

        mCPUBO = new CPUBO();

        mCPUList = mCPUBO.getDesktopProductArrayList();
        if (mCPUList.size() == 0) {
            initDesktop();
            mCPUList = mCPUBO.getDesktopProductArrayList();
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cpu);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProductAdapter(mCPUList);
        recyclerView.setAdapter(adapter);


        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {

        super.onResume();
        mCPUList = mCPUBO.getDesktopProductArrayList();
        adapter.setProductList(mCPUList);
    }

    private void initDesktop() {

        mCPUBO.createDesktopProduct("2017 Newest HP 22 Full HD IPS Display All-in-One DesktopView PC, Intel Pentium Quad Core Processor, 4GB DDR3 RAM, 1TB HDD, Bluetooth, HDMI, DVD, KeyboardView & MouseView Included, Windows 10-Snow White",
                "2017 Newest HP 22 Full HD IPS Display All-in-One DesktopView PC",
                4000,
                R.drawable.desktop1,
                2,
                1);
        mCPUBO.createDesktopProduct("CYBERPOWERPC Gamer Xtreme GXIVR8020A4 DesktopView Gaming PC (Intel i5-7400 3.0GHz, AMD RX 580 4GB, 8GB DDR4 RAM, 1TB 7200RPM HDD, WiFi, Win 10 Home), Black - VR Ready",
                "CYBERPOWERPC Gamer Xtreme GXIVR8020A4 DesktopView Gaming PC (Intel i5-7400 3.0GHz",
                3400,
                R.drawable.desktop2,
                0,
                2);
        mCPUBO.createDesktopProduct("HP All-in-One 21.5\" Full HD IPS High Performance DesktopView PC, Intel Pentium Quad-Core Processor 4GB RAM 1TB 7200RPM HDD DVD+/-RW WIFI Bluetooth HDMI USB 3.0 Windows 10, Silver",
                "HP All-in-One 21.5\" Full HD IPS High Performance DesktopView PC",
                5300,
                R.drawable.desktop3,
                11,
                3);
        mCPUBO.createDesktopProduct("HP Pavilion 23\" Full HD DesktopView PC Bundle, Intel Core i3-4170 Dual-Core Processor, 6GB RAM, 1TB HDD, DVD, WIFI, HDMI, KeyboardView, MouseView, Windows 10",
                "HP Pavilion 23\" Full HD DesktopView PC Bundle",
                5400,
                R.drawable.desktop4,
                12,
                4);
        mCPUBO.createDesktopProduct("HP Pavilion 550-153wb DesktopView PC with Intel Core i3-4170 Dual-Core Processor, 6GB MemoryView, 23 MonitorView, 1TB Hard Drive - Win 10 Home",
                "HP Pavilion 550-153wb DesktopView PC with Intel Core i3-4170 Dual-Core Processor",
                4400,
                R.drawable.desktop5,
                30,
                5);
        mCPUBO.createDesktopProduct("2017 Lenovo IdeaCentre 510S 23\" Full HD IPS Touchscreen All-in-One DesktopView PC, Intel Pentium Dual-Core Processor, 8GB DDR4, 1TB HDD, External DVD, WIFI, HDMI, Wireless KeyboardView + MouseView, Windows 10",
                "2017 Lenovo IdeaCentre 510S 23\" Full HD IPS Touchscreen All-in-One DesktopView PC",
                2500,
                R.drawable.desktop6,
                22,
                6);
        mCPUBO.createDesktopProduct("CyberpowerPC Gamer Ultra GUA3400A Gaming DesktopView - AMD FX-6300 Six Core 3.5GHz, 8GB DDR3 RAM, 1TB HDD, 24X DVD, AMD R7 250 2GB, Windows 10 Home",
                "CyberpowerPC Gamer Ultra GUA3400A Gaming DesktopView - AMD FX-6300 Six Core 3.5GHz",
                6600,
                R.drawable.desktop7,
                55,
                7);
        mCPUBO.createDesktopProduct("HP Elite Windows 10 DesktopView Computer C2D 3.0, New 4 GB, 160 GB, DVDRW, WiFi, 17 inch MonitorView (Certified Refurbished)",
                "HP Elite Windows 10 DesktopView Computer C2D 3.0",
                2070,
                R.drawable.desktop8,
                1,
                8);
        mCPUBO.createDesktopProduct("2017 Acer Aspire All-In-One 19.5\" Full HD 1920x1080 Widescreen DesktopView PC, Intel Celeron Quad-Core Processor, 4GB MemoryView, 500GB Hard Drive, DVD Dirve, Webcam, 802.11ac, Bluetooth, HDMI, Windows 10",
                "2017 Acer Aspire All-In-One 19.5\" Full HD 1920x1080 Widescreen DesktopView PC",
                8100,
                R.drawable.desktop9,
                22,
                9);
    }
}
