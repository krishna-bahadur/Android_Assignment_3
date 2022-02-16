package com.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        btn1 = findViewById(R.id.lbtn);
        btn2 = findViewById(R.id.sbtn);
        email = findViewById(R.id.edit3);
        password = findViewById(R.id.edit4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences sp = getSharedPreferences("detail", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("user",em);
                ed.putString("pass",pass);
                ed.apply();
                Intent i = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
