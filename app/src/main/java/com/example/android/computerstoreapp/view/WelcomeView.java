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

import com.example.android.computerstoreapp.R;
import com.example.android.computerstoreapp.bo.UserBO;

public class WelcomeView extends AppCompatActivity {
    private UserBO mUserBO;
    private TextView emailValidTextView;
    private TextView passwordValidTextView;
    private EditText emailEditText;
    private EditText passwordEditText;

    /**
     * Create a new account
     *
     * @param view
     */
    public void createNewAccount(View view) {
        Log.i("WelcomeView", "You Clicked createNewAccount button");
        Intent i = new Intent(
                WelcomeView.this,
                CreateAccountPageView.class);
        startActivity(i);
    }

    /**
     * check the valid for the email and the password
     *
     * @return true success, otherwise,false
     */
    private boolean isValidLogIn() {
        clearValidTextView();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if ("".equals(email)) {
            emailValidTextView.setText("please input the email address");
            emailValidTextView.setVisibility(View.VISIBLE);
            return false;
        }
        if ("".equals(password)) {
            passwordValidTextView.setText("please input the password");
            passwordValidTextView.setVisibility(View.VISIBLE);
            return false;
        }
        if (mUserBO.isValidUserForLogin(email, password)) {
            return true;
        }
        passwordValidTextView.setText("The user is not exist.");
        passwordValidTextView.setVisibility(View.VISIBLE);
        return false;
    }

    /**
     * When user click login button, log in the computer store app.
     * First check the valid of email and password, if success, go to the home page; if fail, please input the email and password again and give some warning informations
     *
     * @param view
     */
    public void logIn(View view) {
        if (isValidLogIn()) {
            SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
            Editor editor = sharedPreferences.edit();//获取编辑器
            editor.putString("email", emailEditText.getText().toString());
            editor.commit();
            Intent intent = new Intent(
                    WelcomeView.this,
                    HomePageView.class);
            startActivity(intent);
        }
    }

    /**
     * Create the login page
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        emailValidTextView = (TextView) findViewById(R.id.textview_emailValid);
        passwordValidTextView = (TextView) findViewById(R.id.textview_passwordValid);
        emailEditText = (EditText) findViewById(R.id.edit_email);
        passwordEditText = (EditText) findViewById(R.id.edit_password);
        clearValidTextView();
        mUserBO = new UserBO();
    }

    /**
     * hide the warning information
     */
    private void clearValidTextView() {
        emailValidTextView.setVisibility(View.GONE);
        passwordValidTextView.setVisibility(View.GONE);
    }
}
