package com.example.android.computerstoreapp.dao.inf;

import com.example.android.computerstoreapp.entity.OrderAddress;

import java.util.List;

/**
 * Created by android on 2017-11-05.
 */

public interface OrderAddressDAO {
    public boolean register(OrderAddress orderAddress);

    public List<OrderAddress> getOrderAddress(String email);

    public OrderAddress getOrderAddressByEmailAndAddress(String email, String address1, String address2);

}
