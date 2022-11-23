package com.example.bancoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //TABLAS

    String tblClients = "CREATE TABLE clients(ident integer primary key, nombres text, correo text,contrasena text)";
    String tblAccount = "CREATE TABLE accounts(nrocuenta integer primary key, ident integer, fecha text, saldo integer)";
    String tblTransaction = "CREATE TABLE transactions(nrocuenta integer, fecha text, hora text, tipotrans text,valor integer)";
    public Database( Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tblClients);
        db.execSQL(tblAccount);
        db.execSQL(tblTransaction);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE clients");
        db.execSQL(tblClients);
        db.execSQL("DROP TABLE accounts");
        db.execSQL(tblAccount);
        db.execSQL("DROP TABLE transactions");
        db.execSQL(tblTransaction);
    }
}
