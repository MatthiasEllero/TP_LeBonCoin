package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Charger la mise en page

        // Trouver les boutons après avoir chargé la mise en page
        Button b_add = (Button) findViewById(R.id.button_add);
        Button b_display = (Button) findViewById(R.id.button_display);

        // Ajouter un écouteur de clic pour le bouton b_add
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent pour démarrer AdAddActivity
                Intent intent = new Intent(MainActivity.this, AdAddActivity.class);
                startActivity(intent);
            }
        });

        // Ajouter un écouteur de clic pour le bouton b_display
        b_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent pour démarrer AdListViewActivity
                Intent intent = new Intent(MainActivity.this, AdListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
