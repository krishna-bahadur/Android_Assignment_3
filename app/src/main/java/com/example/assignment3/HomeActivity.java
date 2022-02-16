package com.example.assignment3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         data = findViewById(R.id.info);

         data.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(HomeActivity.this,DataActivity.class);
                 startActivity(i);
             }
         });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            SharedPreferences sp = getSharedPreferences("state", MODE_PRIVATE);
            SharedPreferences.Editor et = sp.edit();
            et.putBoolean("loginstate", false);
            et.apply();
            Intent i = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}