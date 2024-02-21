package com.example.tp_leboncoin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeSelectionActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String THEME_PREFERENCE = "themePreference";
    private static final String SELECTED_THEME_KEY = "selectedTheme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        // Récupérer les préférences partagées
        sharedPreferences = getSharedPreferences(THEME_PREFERENCE, MODE_PRIVATE);

        // Récupérer le RadioButton sélectionné précédemment
        int selectedTheme = sharedPreferences.getInt(SELECTED_THEME_KEY, R.id.radioButton1);
        RadioButton radioButton = findViewById(selectedTheme);
        radioButton.setChecked(true);

        // Ajouter un écouteur de changement de RadioButton
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Enregistrer le thème sélectionné dans les préférences partagées
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(SELECTED_THEME_KEY, checkedId);
                editor.apply();

                // Rafraîchir l'activité pour appliquer le nouveau thème
                recreate();

                // Afficher un message de confirmation
                Toast.makeText(ThemeSelectionActivity.this, "Thème changé avec succès", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
