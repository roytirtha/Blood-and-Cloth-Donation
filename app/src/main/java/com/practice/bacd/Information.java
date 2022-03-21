package com.practice.bacd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Information extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText editBloodGroup;
    private TextInputEditText editLocation;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);



        editBloodGroup=(TextInputEditText) findViewById(R.id.editBloodGroup);
        editLocation=(TextInputEditText) findViewById(R.id.editLocation);
        done=(Button)  findViewById(R.id.done);
        done.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
     if(view == done){
         startActivity(new Intent(this,ShowResult.class));
     }
    }


}
