package com.example.android.computerstoreapp.view;



import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.adapter.ProductAdapter;
import com.example.android.computerstoreapp.bo.MouseBO;
import com.example.android.computerstoreapp.entity.Product;

import java.util.List;


public class MouseView extends BaseActivityView {

    protected MouseBO mMouseBO;

    private ProductAdapter adapter;

    private List<? extends Product> mMouseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_mouse_main);


        mMouseBO = new MouseBO();

        mMouseList = mMouseBO.getMouseProductArrayList();
        if (mMouseList.size() == 0) {
            initMouseProduct();
            mMouseList = mMouseBO.getMouseProductArrayList();
        }

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_mouse);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recycler_view_mouse) ;
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2,
                LinearLayoutManager.VERTICAL, false);
        if(recyclerView!=null){
            recyclerView.setLayoutManager(layoutManager);
            adapter = new ProductAdapter(mMouseList);
            recyclerView.setAdapter(adapter);
        }

        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onResume() {

        super.onResume();
        mMouseList = mMouseBO.getMouseProductArrayList();
        adapter.setProductList(mMouseList);
    }

    private void initMouseProduct() {

        mMouseBO.createMouseProduct("VicTsing MM057 2.4G Wireless Portable Mobile Mouse Optical Mice with USB Receiver, 5 Adjustable DPI Levels, 6 Buttons for Notebook, PC, Laptop, Computer, Macbook - Black",
                "VicTsing MM057 2.4G Wireless Portable Mobile Mouse Optical Mice with USB Receiver",
                300,
                R.drawable.mouse1,
                5,
                1,
                false);
        mMouseBO.createMouseProduct("HAVIT HV-MS672 3200DPI Wired Mouse, 4 Adjustable DPI Levels, 800/1200/2400/3200DPI, 7 Circular & Breathing LED Light, 6 Buttons [ Updated Version ]",
                "HAVIT HV-MS672 3200DPI Wired Mouse",
                400,
                R.drawable.mouse2,
                0,
                2,
                true);
        mMouseBO.createMouseProduct("VicTsing 2.4G Slim Wireless Mouse with Nano Receiver, Noiseless and Silent Click with 1600 DPI for PC, Laptop, Tablet, Computer, and Mac, Black",
                "VicTsing 2.4G Slim Wireless Mouse with Nano Receiver",
                500,
                R.drawable.mouse3,
                3,
                3,
                false);
        mMouseBO.createMouseProduct("VicTsing 4-Button Wired USB Optical Mouse with 5ft Cord, Computer Mouse with 3 Adjustable DPI Level (1000/1600/2000), Compatible with PC, Mac, Desktop and Laptop",
                "VicTsing 4-Button Wired USB Optical Mouse with 5ft Cord",
                700,
                R.drawable.mouse4,
                10,
                4,
                true);
        mMouseBO.createMouseProduct("Logitech M510 Wireless Mouse",
                "Logitech M510 Wireless Mouse",
                300,
                R.drawable.mouse5,
                30,
                5,
                false);
        mMouseBO.createMouseProduct("Jelly Comb 2.4G Slim Wireless Mouse with Nano Receiver, Less Noise, Portable Mobile Optical Mice for Notebook, PC, Laptop, Computer, Macbook - Black",
                "Jelly Comb 2.4G Slim Wireless Mouse with Nano Receiver",
                400,
                R.drawable.mouse6,
                20,
                6,
                false);
        mMouseBO.createMouseProduct("TeckNet Classic 2.4G Portable Optical Wireless Mouse with USB Nano Receiver for Notebook,PC,Laptop,Computer,6 Buttons,18 Months Battery Life,2400 DPI,5 Adjustment Levels",
                "TeckNet Classic 2.4G Portable Optical Wireless Mouse with USB Nano Receiver for Notebook",
                1000,
                R.drawable.mouse7,
                20,
                7,
                false);
        mMouseBO.createMouseProduct("VersionTech BX017W 2400 DPI Gaming Mouse with 7 Auto-Changing Color's for Computer/PC/Laptop, USB Wired Mouse, 4 Adjustable DPI Levels with 6 Buttons for Gaming/Gamer, White",
                "VersionTech BX017W 2400 DPI Gaming Mouse with 7 Auto-Changing Color's for Computer/PC/Laptop",
                200,
                R.drawable.mouse8,
                30,
                8,
                true);
        mMouseBO.createMouseProduct("Rechargeable Wireless Mouse,inphic Mute Silent Click Mini Noiseless Optical Mice,Ultra Thin 1600 DPI for Notebook,PC,Laptop,Computer,Macbook (Rose gold)",
                "Rechargeable Wireless Mouse,inphic Mute Silent Click Mini Noiseless Optical Mice",
                1000,
                R.drawable.mouse9,
                11,
                9,
                false);
        mMouseBO.createMouseProduct("Logitech MX Master Wireless Mouse ñ High-precision Sensor, Speed-adaptive Scroll Wheel, Thumb Scroll Wheel, Easy-Switch up to 3 Devices ñ Stone",
                "Logitech MX Master Wireless Mouse ñ High-precision Sensor",
                340,
                R.drawable.mouse10,
                10,
                10,
                false);

    }
}
