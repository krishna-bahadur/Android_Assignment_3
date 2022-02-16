package com.example.assignment3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DataActivity extends AppCompatActivity {

    private RecyclerView recycle;

    private String[] name = {"krishna","sweta","pushpa","shirisha","sachita", "Apurwa","Albish"};
    private String[] address= {"ktm","ktm","ktm","ktm","ktm", "ktm","ktm"};
    private String[] faculty = {"BCA","BBM","CSIT","BSW","BCA","BIM","BSW"};
    private String[] semester = {"6th","5th","4th","5th","6th","7th","6th"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        getSupportActionBar().hide();
        recycle = findViewById(R.id.rv);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(new CustomAdapter(this,name,address,faculty,semester));

    }
}
