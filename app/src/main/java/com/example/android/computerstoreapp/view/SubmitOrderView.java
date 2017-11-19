package com.example.android.computerstoreapp.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.bo.OrderAddressBO;
import com.example.android.computerstoreapp.bo.ShopCartBO;
import com.example.android.computerstoreapp.entity.OrderAddress;
import com.example.android.computerstoreapp.entity.ShopCartProduct;

import java.util.ArrayList;
import java.util.List;

public class SubmitOrderView extends AppCompatActivity {
    private EditText fullnameEditText;
    private EditText address1EditText;
    private EditText address2EditText;
    private EditText cityEditText;
    private EditText stateEditText;
    private EditText zipEditText;
    private EditText phonenumberEditText;
    private TextView submitvalid;

    private String email;

    private OrderAddressBO mOrderAddressBO;
    private ShopCartBO mShopCartBO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_submit_order);

        //get all the input information from the userface
        fullnameEditText = (EditText) findViewById(R.id.order_fullname);
        address1EditText=(EditText) findViewById(R.id.order_address1);
        address2EditText =(EditText)findViewById(R.id.order_address2);
        cityEditText =(EditText)findViewById(R.id.order_city);
        stateEditText = (EditText)findViewById(R.id.order_state);
        zipEditText =(EditText)findViewById(R.id.order_zip);
        phonenumberEditText =(EditText)findViewById(R.id.order_telephone);
        submitvalid=(TextView)findViewById(R.id.submit_valid) ;

        mOrderAddressBO = new OrderAddressBO();
        mShopCartBO= new ShopCartBO();
        //get user's email address
        SharedPreferences sharedPreferences= getSharedPreferences("user",
                Activity.MODE_PRIVATE);

        email =sharedPreferences.getString("email", "");

        //set the submit button's status
        submitvalid.setVisibility(View.INVISIBLE);

        //if user has bought something before, show the addresses which user used.
        setSavedOrderAddress();

        super.onCreate(savedInstanceState);
    }

    /**
     * if user has bought something before, show the addresses which user used.
     */
    private void setSavedOrderAddress(){

       List<OrderAddress> orderAddressList= mOrderAddressBO.getOrderAddress(email);


        for (OrderAddress orderAddress:orderAddressList) {

            final LayoutInflater inflater = LayoutInflater.from(this);

            final LinearLayout rly = (LinearLayout) findViewById(R.id.order_saved_info);
            View view = inflater.inflate(R.layout.order_address_item, null);

            TextView fullnameSavedEditText=(TextView)view.findViewById(R.id.order_fullname_saved);
            TextView address1SavedEditText=(TextView)view.findViewById(R.id.order_address1_saved);
            TextView address2SavedEditText=(TextView)view.findViewById(R.id.order_address2_saved);
            TextView citySavedEditText=(TextView)view.findViewById(R.id.order_city_saved);
            TextView stateSavedEditText=(TextView)view.findViewById(R.id.order_state_saved);
            TextView zipSavedEditText=(TextView)view.findViewById(R.id.order_zip_saved);
            TextView phonenumberSavedEditText=(TextView)view.findViewById(R.id.order_telephone_saved);

            fullnameSavedEditText.setText(orderAddress.getFullname());
            address1SavedEditText.setText(orderAddress.getAddress1());
            address2SavedEditText.setText(orderAddress.getAddress2());
            citySavedEditText.setText(orderAddress.getCity());
            stateSavedEditText.setText(orderAddress.getState());
            zipSavedEditText.setText(orderAddress.getZip());
            phonenumberSavedEditText.setText(orderAddress.getPhonenumber());

            ArrayList<String> params = new ArrayList<>();
            String fullname=fullnameSavedEditText.getText().toString();
            String address1=address1SavedEditText.getText().toString();
            String address2=address2SavedEditText.getText().toString();
            String city=citySavedEditText.getText().toString();
            String state=stateSavedEditText.getText().toString();
            String zip=zipSavedEditText.getText().toString();
            String phonenumber=phonenumberSavedEditText.getText().toString();
            params.add(fullname);
            params.add(address1);
            params.add(address2);
            params.add(city);
            params.add(state);
            params.add(zip);
            params.add(phonenumber);
            params.add(email);


            Button btn = (Button)view.findViewById(R.id.deliver_btn);

            btn.setTag(params);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ArrayList<String> params =(ArrayList<String>) v.getTag();

                    mShopCartBO.deleteShopCart(email);

                    Intent intent = new Intent(SubmitOrderView.this,CreatedOrder.class);
                    startActivity(intent);

                }
            });



            rly.addView(view);

        }


    }

    private ArrayList<String> setPrams(){
        ArrayList<String> params = new ArrayList<>();
        String fullname=fullnameEditText.getText().toString();
        String address1=address1EditText.getText().toString();
        String address2=address2EditText.getText().toString();
        String city=cityEditText.getText().toString();
        String state=stateEditText.getText().toString();
        String zip=zipEditText.getText().toString();
        String phonenumber=phonenumberEditText.getText().toString();
        params.add(fullname);
        params.add(address1);
        params.add(address2);
        params.add(city);
        params.add(state);
        params.add(zip);
        params.add(phonenumber);

        params.add(email);
        return params;
    }

    public void deliverToThisAddress(View view){

        ArrayList<String> params =setPrams();

        submitvalid.setVisibility(View.INVISIBLE);
        ArrayList<Boolean> isValid = mOrderAddressBO.isValid(params);
        for(int i =0;i<isValid.size();i++){
            if(!isValid.get(i)){
                submitvalid.setVisibility(View.VISIBLE);
                return;
            }
        }
        OrderAddress orderAddress = mOrderAddressBO.createOrderAddress(params);

        if(orderAddress == null)
        {
            Toast.makeText(getApplicationContext(),"The address has been created!",Toast.LENGTH_SHORT).show();

        }else{
            String emailContent ="";
            int num = getIntent().getIntExtra("num",0);
            for(int i =0;i<num;i++){
                ShopCartProduct product =(ShopCartProduct)getIntent().getSerializableExtra("shopcart" + i);
                emailContent += product.toString();
            }
            emailContent += orderAddress.toString();

        }

        mShopCartBO.deleteShopCart(email);

        Intent intent = new Intent(this,CreatedOrder.class);
        startActivity(intent);
    }
}
