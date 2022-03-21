package com.practice.bacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClothDonationP extends AppCompatActivity implements View.OnClickListener {

    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_donation_p);
        btnBack= (Button) findViewById(R.id.btnBack) ;
        btnBack.setOnClickListener( this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnBack){
            startActivity(new Intent(this,ClothMain.class));
        }
    }
}
