package com.practice.bacd;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;


    private DatabaseReference databaseReference;

    private TextInputEditText editTextName,editLocation,editBloodGroup,editContactNo;
    private Button buttonUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth= FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }


        databaseReference = FirebaseDatabase.getInstance().getReference("userinformation");

        editLocation =(TextInputEditText)  findViewById(R.id.editLocation);
        editTextName =(TextInputEditText)  findViewById(R.id.editTextName);
        editBloodGroup =(TextInputEditText)  findViewById(R.id.editBloodGroup);
        editContactNo =(TextInputEditText)  findViewById(R.id.editContactNo);

        buttonUpdate=(Button)  findViewById(R.id.buttonUpdate);
        FirebaseUser user= firebaseAuth.getCurrentUser();

        textViewUserEmail =(TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome "+user.getEmail());
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
    }
    private void saveUserInformation(){
        String name=editTextName.getText().toString().trim();
        String location=editLocation.getText().toString().trim();
        String bloodgroup=editBloodGroup.getText().toString().trim();
        String contactNo=editContactNo.getText().toString().trim();

        String id=databaseReference.push().getKey();
        Userinformation userinformation = new Userinformation(id,name,location,bloodgroup,contactNo);
        databaseReference.child(id).setValue(userinformation);
        //FirebaseUser user= firebaseAuth.getCurrentUser();
        //databaseReference.child(user.getUid()).setValue(userinformation);
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
        if(view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if(view == buttonUpdate){
            saveUserInformation();
            finish();
            startActivity(new Intent(this,Request.class));
        }
    }


}
