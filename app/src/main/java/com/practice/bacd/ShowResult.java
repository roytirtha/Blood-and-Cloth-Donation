package com.practice.bacd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.layout.simple_dropdown_item_1line;
import static android.R.layout.simple_spinner_dropdown_item;

public class ShowResult extends AppCompatActivity implements View.OnClickListener {

   DatabaseReference ref;
   ArrayList<Userinformation>list;
   RecyclerView recyclerView;
   SearchView searchView;
  private  Button Show_on_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        ref=FirebaseDatabase.getInstance().getReference().child("userinformation");
        recyclerView =findViewById(R.id.rv);
        searchView =findViewById(R.id.searchView);
        Show_on_map=findViewById(R.id.Show_on_map);
        Show_on_map.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(ref!=null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        list=new ArrayList<>();
                        
                        for(DataSnapshot ds: dataSnapshot.getChildren()){
                            list.add(ds.getValue(Userinformation.class) );
                        }
                        AdpterClass adpterClass =new AdpterClass(list);
                        recyclerView.setAdapter(adpterClass);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        
        if(searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }
    private void search(String str){
        ArrayList<Userinformation>myList =new ArrayList<>();
        for(Userinformation object:list){
            if(object.getLocation().toLowerCase().contains(str.toLowerCase()) ){
                myList.add(object);
            }
        }
        AdpterClass adpterClass=new AdpterClass(myList);
        recyclerView.setAdapter(adpterClass);
    }

    @Override
    public void onClick(View v) {
        if(v==Show_on_map){
           startActivity(new Intent(this,Maps.class));
        }
    }
}


