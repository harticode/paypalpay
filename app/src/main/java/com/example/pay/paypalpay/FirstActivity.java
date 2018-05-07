package com.example.pay.paypalpay;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final Intent intent = new Intent(this, SecondActivity.class);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                startActivity(intent);
                finish();

            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 2000); // will be delayed for 2 seconds
    }
}
