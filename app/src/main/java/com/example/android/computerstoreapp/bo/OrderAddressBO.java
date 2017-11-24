package com.example.android.computerstoreapp.bo;

import com.example.android.computerstoreapp.dao.impl.OrderAddressDAOInternal;
import com.example.android.computerstoreapp.dao.inf.OrderAddressDAO;
import com.example.android.computerstoreapp.entity.OrderAddress;

import java.util.ArrayList;
import java.util.List;

public class OrderAddressBO {
    private OrderAddress mOrderAddress;
    private OrderAddressDAO mOrderAddressDAOInternal;

    public OrderAddressBO() {
        mOrderAddressDAOInternal = new OrderAddressDAOInternal();
    }

    public OrderAddress createOrderAddress(ArrayList<String> params) {
        OrderAddress savedOrderAddress = mOrderAddressDAOInternal.getOrderAddressByEmailAndAddress(params.get(7),
                params.get(1),
                params.get(2));
        if (savedOrderAddress == null) {
            mOrderAddress = new OrderAddress(params);
            mOrderAddressDAOInternal.register(mOrderAddress);
            return mOrderAddress;
        }
        return null;
    }

    public List<OrderAddress> getOrderAddress(String email) {
        List<OrderAddress> orderAddressList = mOrderAddressDAOInternal.getOrderAddress(email);
        return orderAddressList;
    }

    public ArrayList<Boolean> isValid(ArrayList<String> params) {
        ArrayList<Boolean> isValid = new ArrayList<>();
        for (int i = 0; i < params.size() - 1; i++) {
            if ("".equals(params.get(i).trim())) {
                isValid.add(i, false);
            } else {
                isValid.add(i, true);
            }
        }
        return isValid;
    }
}
