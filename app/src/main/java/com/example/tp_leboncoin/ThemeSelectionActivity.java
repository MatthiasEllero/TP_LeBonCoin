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

        int selectedThemeId = getResources().getIdentifier(ThemeSelectionActivity.SELECTED_THEME, "style", getPackageName());
        setTheme(selectedThemeId);

        setContentView(R.layout.activity_theme_selection);

        Button btnTheme1 = findViewById(R.id.btnTheme1);
        Button btnTheme2 = findViewById(R.id.btnTheme2);
        Button btnTheme3 = findViewById(R.id.btnTheme3);
        Button btnTheme4 = findViewById(R.id.btnTheme4);
        Button btnTheme5 = findViewById(R.id.btnTheme5);

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

        btnTheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECTED_THEME = "AppThemePinkPurple";
                applyThemeAndRestart();
            }
        });

        btnTheme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SELECTED_THEME = "Base.Theme.TP_LeBonCoin";
                applyThemeAndRestart();
            }
        });
    }

    private void applyThemeAndRestart() {
        // Redémarre l'activité principale pour appliquer le nouveau thème
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
