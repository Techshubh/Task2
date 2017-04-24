package com.example.task2.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class RegisterBuy extends AppCompatActivity {
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_buy);
        //action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
