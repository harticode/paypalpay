package com.example.pay.paypalpay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    String site = "https://www.houssambakkioui.com/"; //your website here
    TextView mtxtid, mtxtAmount, mtxtStatus;
    Button mweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        mtxtid = (TextView) findViewById(R.id.txtid);
        mtxtAmount = (TextView) findViewById(R.id.txtAmount);
        mtxtStatus = (TextView) findViewById(R.id.txtStatus);
        mweb = (Button) findViewById(R.id.web);

        Intent intent = getIntent();

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            ShowDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse(site);
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, website);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }

    private void ShowDetails(JSONObject response, String paymentAmount) {
        try {
            mtxtid.setText("the ID = " + response.getString("id"));
            mtxtStatus.setText("the state = "+ response.getString("state"));
            mtxtAmount.setText(String.format("$%s", paymentAmount));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
