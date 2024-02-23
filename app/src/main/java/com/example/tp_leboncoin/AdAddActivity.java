package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tp_leboncoin.sqlite.DBManager;

public class AdAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int selectedThemeId = getResources().getIdentifier(ThemeSelectionActivity.SELECTED_THEME, "style", getPackageName());
        setTheme(selectedThemeId);

        setContentView(R.layout.activity_ad_add);

        final EditText editTextProductName = findViewById(R.id.textProduit);
        final EditText editTextAddress = findViewById(R.id.textAdress);
        final EditText editTextImageUrl = findViewById(R.id.textImageUrl);
        final EditText editTextPhone = findViewById(R.id.textPhone);
        Button bsend = findViewById(R.id.bsend);

        bsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération des valeurs entrées par l'utilisateur
                String productName = editTextProductName.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();
                String imageUrl = editTextImageUrl.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim(); // Récupération du numéro de téléphone

                // Initialisation de DBManager pour l'insertion des données
                DBManager dbManager = DBManager.getDBManager(AdAddActivity.this);
                dbManager.open();

                // Création d'un nouvel objet AdModel et insertion dans la base de données
                AdModel newAd = new AdModel(productName, address, phone, imageUrl);
                dbManager.insert(newAd);

                dbManager.close(); // Fermeture de la base de données

                // Démarrage de AdListViewActivity pour afficher la liste mise à jour
                Intent intent = new Intent(AdAddActivity.this, AdListViewActivity.class);
                startActivity(intent);
                finish(); // Ferme AdAddActivity pour ne pas revenir à cette activité après AdListViewActivity
            }
        });
    }
}
