package com.practice.bacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ClothMain extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button btnClothDp;
    private Button btnCharity;
    private Button btnClothDpoint;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_main);
        firebaseAuth= FirebaseAuth.getInstance();
        textViewUserEmail =(TextView) findViewById(R.id.textViewUserEmail);
        btnClothDp =(Button) findViewById(R.id.btnClothDp) ;
        btnCharity =(Button) findViewById(R.id.btnCharity);
        btnClothDpoint=(Button) findViewById(R.id.btnClothDpoint);
        buttonBack =(Button) findViewById(R.id.buttonBack);
        FirebaseUser user= firebaseAuth.getCurrentUser();

        textViewUserEmail.setText("Welcome "+user.getEmail());
        btnClothDp.setOnClickListener(this);
        btnCharity.setOnClickListener(this);
        btnClothDpoint.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnClothDp){
            startActivity(new Intent(this,ClothDonationP.class));
        }
        if(v==btnCharity){
            startActivity(new Intent(this,CharityD.class));
        }
        if(v==btnClothDpoint){
            startActivity(new Intent(this,Mapcloth.class));
        }
        if(v==buttonBack){
            startActivity(new Intent(this,Request.class));
        }
    }
}
