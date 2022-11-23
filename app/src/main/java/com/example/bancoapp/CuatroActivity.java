package com.example.bancoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CuatroActivity extends AppCompatActivity {


        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.transaccion);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            Button back = findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(CuatroActivity.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }
    }

