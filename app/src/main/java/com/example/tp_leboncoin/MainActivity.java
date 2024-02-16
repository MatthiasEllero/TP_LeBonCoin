package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Création des boutons cliquables
        Button b_add = (Button) findViewById(R.id.button_add);
        Button b_display = (Button) findViewById(R.id.button_display);

        setContentView(R.layout.activity_main);
    }
}