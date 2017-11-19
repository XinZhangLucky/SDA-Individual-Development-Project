package com.example.android.computerstoreapp.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.bo.UserBO;
import com.example.android.computerstoreapp.entity.User;

public class CreateAccountPageView extends AppCompatActivity {
    //the input name
    private String name;
    //the input email
    private String email;
    //the input password
    private String password;
    //the input re-enter password
    private String passwordReEnter;


    private UserBO mUserBO;
    //the textview of the displayed error message for the name
    private TextView nameValid;
    //the textview of the displayed error message for the email
    private TextView emailValid;
    //the textview of the displayed error message for the password
    private TextView passwordValid;

    //the edittext of the email
    private EditText emalEditText;
    //the edittext of the name
    private EditText nameEditText;
    //the edittext of the password
    private EditText passwordEditText;
    //the edittext of the re-enter password
    private EditText passwordReEnterEditText;


    /**
     * when click the 'Create your account' button, create new account.
     *
     * @param view
     */
    public void createAccount(View view) {

        Log.d("CreateAccountPageView", "create");

        init();
        clearValidTextView();
        if (isValidCreateAccount()) {
            User user =mUserBO.createUserForCustomer(name, password, email);

            Toast.makeText(getApplicationContext(),"Your Account has been created!",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(
                    CreateAccountPageView.this,
                    HomePageView.class);

            SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
            Editor editor = sharedPreferences.edit();//获取编辑器

            editor.putString("email", user.getUserEmail());
            editor.commit();

            startActivity(intent);
        }

    }

    /**
     * valid all input information
     *
     * @return true all input information is legal,otherwise false
     */
    private boolean isValidCreateAccount() {
        boolean flag = true;
        if ("".equals(name)) {
            nameValid.setText("please input the name");
            nameValid.setVisibility(View.VISIBLE);
            flag = false;
        }
        if ("".equals(email)) {
            emailValid.setText("please input the email");
            emailValid.setVisibility(View.VISIBLE);
            flag = false;
        }
        if ("".equals(password) || "".equals(passwordReEnter)) {
            passwordValid.setText("please input the password");
            passwordValid.setVisibility(View.VISIBLE);
            flag = false;
        }

        //password and re-enter password are not the same
        if (!password.equals(passwordReEnter)) {
            passwordValid.setText("the password and the re-enter password is not the same");
            passwordValid.setVisibility(View.VISIBLE);
            flag = false;
        }
        //email has been used, so set the wrong message
        if (mUserBO.hasExistEmail(email)) {

            emailValid.setText("The email has been used");
            emailValid.setVisibility(View.VISIBLE);
            flag = false;
        }

        return flag;
    }

    /**
     * get the input information of the page
     */
    private void init() {

        name = (nameEditText != null) ? nameEditText.getText().toString() : "";

        email = (emalEditText != null) ? emalEditText.getText().toString() : "";

        password = (passwordEditText != null) ? passwordEditText.getText().toString() : "";

        passwordReEnter = (passwordReEnterEditText != null) ? passwordReEnterEditText.getText().toString() : "";

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        mUserBO = new UserBO();

        nameValid = (TextView) findViewById(R.id.nameValid_textView);

        emailValid = (TextView) findViewById(R.id.emailValid_textView);

        passwordValid = (TextView) findViewById(R.id.passwordValid_textView);

        nameEditText = (EditText) findViewById(R.id.name_editText);
        emalEditText = (EditText) findViewById(R.id.email_editText);

        passwordEditText = (EditText) findViewById(R.id.password_editText);
        passwordReEnterEditText = (EditText) findViewById(R.id.passwordReEnter_editText);

        clearValidTextView();

    }

    /**
     * Hide all error message
     */
    private void clearValidTextView() {
        //email error message
        emailValid.setVisibility(View.GONE);
        //name error message
        nameValid.setVisibility(View.GONE);
        //password error message
        passwordValid.setVisibility(View.GONE);
    }
}
