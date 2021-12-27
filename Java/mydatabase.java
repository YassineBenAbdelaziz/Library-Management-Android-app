/*
Sqlite data base and table creation , extends SQLiteOpenHelper



*/
package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class mydatabase extends  SQLiteOpenHelper {

    private static  int version = 1;
    private static  String dbname = "Biblio";
    private static final String tableLivre = "CREATE TABLE Livre ( id number(3) Primary Key, titre char );";

    public mydatabase(Context context){
        super(context, dbname, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableLivre);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
