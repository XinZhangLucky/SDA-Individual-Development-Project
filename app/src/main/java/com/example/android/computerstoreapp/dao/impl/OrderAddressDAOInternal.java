package com.example.android.computerstoreapp.dao.impl;

import android.database.Cursor;

import com.example.android.computerstoreapp.dao.inf.OrderAddressDAO;
import com.example.android.computerstoreapp.entity.OrderAddress;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class OrderAddressDAOInternal implements OrderAddressDAO {
    private final static String classtype = "orderaddress";

    @Override
    public boolean register(OrderAddress orderAddress) {
        return orderAddress.save();
    }

    public List<OrderAddress> getOrderAddress(String email) {
        List<OrderAddress> orderAddressList = new ArrayList<>();
        Cursor cursor = DataSupport.findBySQL("SELECT * FROM " + classtype + " WHERE email = '" + email + "'");
        while (cursor.moveToNext()) {
            OrderAddress orderAddress = createSavedOrderAddress(cursor, email);
            orderAddressList.add(orderAddress);
        }
        return orderAddressList;
    }

    private OrderAddress createSavedOrderAddress(Cursor cursor, String email) {
        String fullname = cursor.getString(cursor.getColumnIndex("fullname"));
        String address1 = cursor.getString(cursor.getColumnIndex("address1"));
        String address2 = cursor.getString(cursor.getColumnIndex("address2"));
        String city = cursor.getString(cursor.getColumnIndex("city"));
        String state = cursor.getString(cursor.getColumnIndex("state"));
        String zip = cursor.getString(cursor.getColumnIndex("zip"));
        String phonenumber = cursor.getString(cursor.getColumnIndex("phonenumber"));
        ArrayList<String> params = new ArrayList<>();
        params.add(fullname);
        params.add(address1);
        params.add(address2);
        params.add(city);
        params.add(state);
        params.add(zip);
        params.add(phonenumber);
        params.add(email);
        return new OrderAddress(params);
    }

    @Override
    public OrderAddress getOrderAddressByEmailAndAddress(String email, String address1, String address2) {
        OrderAddress orderAddress = null;
        Cursor cursor = DataSupport.findBySQL("SELECT * FROM " + classtype +
                " WHERE email = '" + email + "' AND address1 = '" + address1 + "' AND address2 = '" + address2 + "'");
        while (cursor.moveToNext()) {
            orderAddress = createSavedOrderAddress(cursor, email);
        }
        return orderAddress;
    }
}
