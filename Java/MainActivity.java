/*
Main activity java file has onclick listeners that creates intents for each called activity.

*/


package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {
    private Button base,site,maps,date ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base =findViewById(R.id.button_base);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),data_activity.class);
                startActivity(intent);
            }
        });

        site = findViewById(R.id.button_nav);
        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri url = Uri.parse("https://www.alkitab.tn/");
                Intent intent = new Intent(ACTION_VIEW,url);
                startActivity(intent);
            }
        });

        maps = findViewById(R.id.button_maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri coord = Uri.parse("geo:"+ "36.80002629234219, 10.182151462447418");
                Intent intent = new Intent(ACTION_VIEW,coord);
                startActivity(intent);
            }
        });

        date = findViewById(R.id.button_date) ;
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                startActivity(intent);
            }
        });



    }





}