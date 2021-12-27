/*
Controleur class handles data base operations : open, close, insert, update, select, delete


*/
package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class Controleur {

    SQLiteDatabase db = null ;
    mydatabase connector = null ;


    public Controleur(Context context) {
        this.connector = new mydatabase(context);
    }



    public void open(){
        db = connector.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public  boolean insert(Livre livre) {

        ContentValues values = new ContentValues();
        values.put("id", String.valueOf(livre.getId()));
        values.put("titre", livre.getTitre());

        long id = db.insert("Livre", null, values);
        if (id > 0) {
            return true;
        }
        else {
            return false;

        }


    }
    public List<String> select() {
        List<String> list = new ArrayList<String>();
        Cursor curso = db.query("Livre",new String[]{"id,titre"},null,null,null,null,null);
        while (curso.moveToNext()){
            list.add(curso.getString(0) + " | " +  curso.getString(1));

            }
        return list;


        }

    public List<String> selectparam(String titre) {
        List<String> list = new ArrayList<String>();
        String idf[] = {titre + '%'};
        Cursor curso = db.query("Livre",new String[]{"id,titre"},"titre LIKE ?",idf,null,null,null);
        while (curso.moveToNext()){
            list.add(curso.getString(0) + " | " +  curso.getString(1));

        }
        return list;


    }


    public  boolean delete(String id){

        int ok = db.delete("Livre","id=?", new String[]{id});

        if (ok == 0){

            return  false ;
        }
        else  {
            return  true ;

        }

    }

    public boolean update(Livre livre){
        ContentValues values = new ContentValues();

        String idf[] = {String.valueOf(livre.getId())};

        values.put("id",String.valueOf(livre.getId()));
        values.put("titre",livre.getTitre());

        long id = db.update("Livre",values,"id=?",idf);
        if (id >0) {
            return  true ;
        }
        else  {
            return  false ;
        }
    }




    }


