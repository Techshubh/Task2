package com.example.task2.task2;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends AppCompatActivity {
    private TextView t;
    private String id;
    private LoginButton login_button;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        controls();
        loginWithfb();

        Intent i=getIntent();
         id=i.getStringExtra("id");
        setTitle(id);
        id=id.toUpperCase();
        t=(TextView)findViewById(R.id.Loginname);
        t.setText("LOGIN  AS "+ id );



    }

    public void controls(){
        callbackManager=CallbackManager.Factory.create();
        login_button=(LoginButton)findViewById(R.id.login_button);

    }

    private void loginWithfb()
    {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(Login.this, "Login Success"+loginResult.getAccessToken(),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancel() {

                Toast.makeText(Login.this, "Login cancel",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(Login.this, error.getMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });
    }



    public void Register(View v)
    {
        if(id.equals("SELLER"))
        {
            Intent s=new Intent(this,RegisterSell.class);
            startActivity(s);
        }
        else {
            Intent b=new Intent(this,RegisterBuy.class);
            startActivity(b);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
