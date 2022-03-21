package com.practice.bacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharityD extends AppCompatActivity implements View.OnClickListener {

    private Button btn_KIN;
    private Button btn_Sp;
    private Button btn_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_d);
        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Sp = (Button) findViewById(R.id.btn_Sp);
        btn_KIN = (Button) findViewById(R.id.btn_KIN);
        btn_Back.setOnClickListener(this);
        btn_KIN.setOnClickListener(this);
        btn_Sp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_Back){
            startActivity(new Intent(this,ClothMain.class));
        }
        if(v==btn_KIN){
            startActivity(new Intent(this,CharityDonate2.class));
        }
        if(v==btn_Sp){
            startActivity(new Intent(this,CharityDonate2.class));
        }
    }
}
