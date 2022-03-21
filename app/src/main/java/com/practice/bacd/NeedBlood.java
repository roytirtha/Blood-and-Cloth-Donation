package com.practice.bacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NeedBlood extends AppCompatActivity implements View.OnClickListener {

    private Button btnNeedBlood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_blood);
        btnNeedBlood = (Button) findViewById(R.id.btnNeedBlood);
        btnNeedBlood.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnNeedBlood){
            startActivity(new Intent(this,ShowResult.class));
        }
    }
}
