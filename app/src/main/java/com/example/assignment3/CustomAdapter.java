package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    String[] Name, Address, Faculty, MySem;

    public CustomAdapter(DataActivity m, String[] name, String[] address, String[] faculty, String[] semester) {
        c = m;
        Name = name;
        Address = address;
        Faculty = faculty;
        MySem = semester;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.single_item,null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText("Name: " +Name[position]);
        holder.tv1.setText("Address: "+Address[position]);
        holder.tv2.setText("Faculty: "+Faculty[position]);
        holder.tv3.setText("Semester: "+MySem[position]);
    }

    @Override
    public int getItemCount() {
        return Name.length;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv,tv1,tv2,tv3;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tv = itemView.findViewById(R.id.name);
            tv1 = itemView.findViewById(R.id.address);
            tv2 = itemView.findViewById(R.id.faculty);
            tv3 = itemView.findViewById(R.id.sem);
        }
    }
}

