package com.example.task2.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView seller,buyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sell(View v){
        Intent s=new Intent(this,Login.class);
        s.putExtra("id","Seller");

        startActivity(s);




    }
    public void buy(View v)
    {
        Intent b=new Intent(this,Login.class);
        b.putExtra("id","Buyer");
        startActivity(b);
    }

}
