package com.example.task2.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class RegisterSell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_sell);

        //action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public  void SignS(View v)
    {
        Intent s=new Intent(this,Login.class);
        s.putExtra("id","Seller");

        startActivity(s);


    }

    public void otp1(View v)
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
