package com.example.assignment3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    Button login,sign;
    EditText em,pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        loginstatus();

        login = findViewById(R.id.button_log);
        sign = findViewById(R.id.button_sign);

        em  = findViewById(R.id.email);
        pa  = findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fetch from file
                SharedPreferences sp = getSharedPreferences("detail",MODE_PRIVATE);
                String femail = sp.getString("user","code1");
                String fpass = sp.getString("pass","code2");

                //fetch from user
                String user_email = em.getText().toString();
                String user_pass = pa.getText().toString();
                if(femail.equals(user_email) && fpass.equals(user_pass)) {
                    Toast.makeText(LoginActivity.this, "Successfully looged in", Toast.LENGTH_LONG).show();

                    SharedPreferences lp = getSharedPreferences("state", MODE_PRIVATE);
                    SharedPreferences.Editor et = lp.edit();
                    et.putBoolean("loginstate", true);
                    et.apply();

                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Incorrect email or password",Toast.LENGTH_LONG).show();
                }
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(i);
            }
        });
    }
    private void loginstatus(){
        SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
        boolean state = sp.getBoolean("loginstate",false);
        if(state){
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }
}
