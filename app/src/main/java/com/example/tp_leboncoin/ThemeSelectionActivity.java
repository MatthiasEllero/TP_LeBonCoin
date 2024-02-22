package com.example.tp_leboncoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeSelectionActivity extends AppCompatActivity {

    // Variable globale pour stocker le thème sélectionné
    public static String SELECTED_THEME = "Base.Theme.TP_LeBonCoin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        Button btnTheme1 = findViewById(R.id.btnTheme1);
        Button btnTheme2 = findViewById(R.id.btnTheme2);
        Button btnTheme3 = findViewById(R.id.btnTheme3);

        btnTheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECTED_THEME = "AppThemeYellowOrange";
                applyThemeAndRestart();
            }
        });

        btnTheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECTED_THEME = "AppThemeBlueLightBlue";
                applyThemeAndRestart();
            }
        });

        btnTheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECTED_THEME = "AppThemeGreenDarkGreen";
                applyThemeAndRestart();
            }
        });

        // Ajoutez des listeners pour d'autres boutons de thème si nécessaire
    }

    private void applyThemeAndRestart() {
        // Redémarre l'activité principale pour appliquer le nouveau thème
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
