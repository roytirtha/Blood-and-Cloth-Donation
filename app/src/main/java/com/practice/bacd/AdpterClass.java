package com.practice.bacd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdpterClass extends RecyclerView.Adapter<AdpterClass.MyViewHolder> {

    ArrayList<Userinformation>list;
    public AdpterClass(  ArrayList<Userinformation>list){
        this.list=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.blood_info,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
     myViewHolder.name.setText(list.get(i).getName());
     myViewHolder.desc.setText(list.get(i).getLocation());
     myViewHolder.editcontactNo.setText(list.get(i).getContactNo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
     TextView name,desc,editcontactNo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            desc=itemView.findViewById(R.id.description);
            editcontactNo=itemView.findViewById(R.id.editcontactNo);
        }
    }


}
