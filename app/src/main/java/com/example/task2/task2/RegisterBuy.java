package com.example.task2.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterBuy extends AppCompatActivity {
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_buy);

    }

    public  void SignB(View v)
    {
        Intent b=new Intent(this,Login.class);
        b.putExtra("id","Buyer");
        startActivity(b);
    }

    public void otp(View v)
    {
        Intent o=new Intent(this,otp.class);
        startActivity(o);
    }
}
