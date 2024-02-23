package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Appliquer le thème sélectionné avant d'inflater la mise en page de l'activité principale

        int selectedThemeId = getResources().getIdentifier(ThemeSelectionActivity.SELECTED_THEME, "style", getPackageName());
        setTheme(selectedThemeId);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_add = findViewById(R.id.button_add);
        Button b_display = findViewById(R.id.button_display);
        Button b_camera = findViewById(R.id.button_camera);

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

        // Ajouter un écouteur de clic pour le bouton b_camera
        b_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraAdAddActivity.class);
                startActivity(intent);
            }
        });

        Button themeButton = findViewById(R.id.themeButton);

        // Ajouter un écouteur de clic pour le bouton de thème
        themeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Démarrer l'activité de sélection de thème
                Intent intent = new Intent(MainActivity.this, ThemeSelectionActivity.class);
                startActivity(intent);
            }
        });
    }

}
