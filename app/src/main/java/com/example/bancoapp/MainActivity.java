package com.example.bancoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Database sohClients = new Database(this,"dbClients",null,1);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        EditText idclient = findViewById(R.id.etidclient);
        EditText passwordclient = findViewById(R.id.etclientpassword);
        Button btnenter = findViewById(R.id.BotonCrud);
        Button btnregister = findViewById(R.id.btnregister);


        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!idclient.getText().toString().isEmpty()&&!passwordclient.getText().toString().isEmpty()){
                    SQLiteDatabase dbr = sohClients.getReadableDatabase();
                    String query = "SELECT ident FROM clients WHERE ident ='"+idclient.getText().toString()+"'";
                    Cursor cursorSearch = dbr.rawQuery(query,null);
                    if(cursorSearch.moveToFirst()){
                        Intent iClients = new Intent(getApplicationContext(),TresActivity.class);
                        iClients.putExtra("midclient",idclient.getText().toString());
                        startActivity(iClients);
                    }else{
                        Toast.makeText(getApplicationContext(),"Cliente no registrado",Toast.LENGTH_SHORT).show();
                    }
                    dbr.close();
                }

                else{
                    Toast.makeText(getApplicationContext(),"Ingrese todos los datos",Toast.LENGTH_SHORT).show();

                }

            }
        });


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DosActivity.class);
                startActivity(i);
            }
        });

    }
}