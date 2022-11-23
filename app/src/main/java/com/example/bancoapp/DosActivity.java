package com.example.bancoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DosActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientcrud);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btncreateaccount = findViewById(R.id.createaccount);
        EditText idclient = findViewById(R.id.idclient);
        EditText fullname = findViewById(R.id.fullname);







        btncreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DosActivity.this,TresActivity.class);
                startActivity(i);
            }
        });

        Button btntrans = findViewById(R.id.btntrans);

        btntrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DosActivity.this,CuatroActivity.class);
                startActivity(i);
            }
        });
}
}
