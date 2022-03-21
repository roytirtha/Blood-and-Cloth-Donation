package com.practice.bacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Maps extends AppCompatActivity implements View.OnClickListener {
     private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        buttonLogout=(Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogout){
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}
