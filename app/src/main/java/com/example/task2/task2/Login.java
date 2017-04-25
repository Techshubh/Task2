package com.example.task2.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class Login extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    private static final int REQ_CODE = 9001;
    CallbackManager callbackManager;
    private TextView t;
    private String id;
    private LoginButton login_button;
    private Button Signin, fb;
    private Button Signout;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        controls();
        loginWithfb();

        //action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        Intent i=getIntent();
         id=i.getStringExtra("id");
        setTitle(id);
        id=id.toUpperCase();
        t=(TextView)findViewById(R.id.Loginname);
        t.setText("LOGIN  AS "+ id );


        Signin = (Button) findViewById(R.id.bn_login);

        Signin.setOnClickListener(this);
        fb = (Button) findViewById(R.id.fb);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)

            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bn_login:
                signin();
                break;

        }

    }


    private void signin() {

        String t = Signin.getText().toString();

        if (t.equals("Google +")) {

            Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
            startActivityForResult(intent, REQ_CODE);
        } else {
            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(@NonNull Status status) {
                    Signin.setText("Google +");
                    Toast.makeText(Login.this, "logged out",
                            Toast.LENGTH_LONG).show();
                }
            });
        }

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void controls(){

        callbackManager=CallbackManager.Factory.create();
        login_button = (LoginButton) findViewById(R.id.login_button1);

    }

    public void onClick1(View v) {
        if (v == fb) {
            login_button.performClick();
        }
    }

    private void loginWithfb()

    {

        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(Login.this, "Login Success" + loginResult.getAccessToken(),
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

        if (requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                Signin.setText("Logout");
                Toast.makeText(Login.this, "Google Sign in Success",
                        Toast.LENGTH_LONG).show();
            }
        }

    }
}
