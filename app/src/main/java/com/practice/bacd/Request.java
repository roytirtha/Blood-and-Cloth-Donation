package com.practice.bacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Request extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogout;
    private FirebaseAuth firebaseAuth;
    private ImageButton imageButtonBloodDonation;
    private ImageButton imageButtonDonateClothe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        firebaseAuth= FirebaseAuth.getInstance();
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
         imageButtonBloodDonation = (ImageButton) findViewById(R.id.imageButtonBloodDonation);
         imageButtonDonateClothe =(ImageButton)  findViewById(R.id.imageButtonDonateClothe);
        imageButtonBloodDonation.setOnClickListener( this);
        imageButtonDonateClothe.setOnClickListener(this);
        buttonLogout.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if(view == imageButtonBloodDonation){
            startActivity(new Intent(this,NeedBlood.class));
        }
        if(view == imageButtonDonateClothe){
            startActivity(new Intent(this,ClothMain.class));
        }
    }
}
