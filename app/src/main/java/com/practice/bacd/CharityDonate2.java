package com.practice.bacd;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class CharityDonate2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName, editContactNo, editDonationAmount, editClothType;
    private Button btn_Done, btn_Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_donate2);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editContactNo = (EditText) findViewById(R.id.editContactNo);
        editDonationAmount = (EditText) findViewById(R.id.editDonationAmount);
        editClothType = (EditText) findViewById(R.id.editClothType);
        btn_Done = (Button) findViewById(R.id.btn_Done);
        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Done.setOnClickListener(this);
        btn_Back.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btn_Back) {
            startActivity(new Intent(this, CharityD.class));
        }
        if (v == btn_Done) {

            String recipient= editTextName.getText().toString().trim();
            String body2 = (editContactNo.getText()).toString().trim();
            String body3 = (editDonationAmount.getText()).toString().trim();
            String body4 = (editClothType.getText()).toString().trim();

            sendEmail(recipient,body2,body3,body4);




        }


    }

    private void sendEmail(String recipient, String body2, String body3, String body4) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {"Kinvoluntaryorganization@gmail.com","sopnotthan@gmail.com"});
        email.putExtra(Intent.EXTRA_TEXT, body2);
        email.putExtra(Intent.EXTRA_TEXT, body3);
        email.putExtra(Intent.EXTRA_TEXT, body4);

        try{

            startActivity(Intent.createChooser(email, "send email"));
        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}