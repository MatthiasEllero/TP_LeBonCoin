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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Charger la mise en page

        // Trouver les boutons après avoir chargé la mise en page
        Button b_add = findViewById(R.id.button_add);
        Button b_display = findViewById(R.id.button_display);

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

    // Méthode pour composer le numéro de téléphone
    public void callPhoneNumber(View view) {
        // Récupérer le numéro de téléphone à partir d'une source quelconque (par exemple une variable ou une ressource)
        String phoneNumber = "0769178770";

        // Créer une intention d'appel
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        // Vérifier si l'application d'appel est disponible sur l'appareil
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Démarrer l'intention
            startActivity(intent);
        } else {
            // Gérer le cas où aucune application d'appel n'est disponible
            Toast.makeText(this, "Aucune application d'appel n'est disponible.", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendEmail(View view) {
        // Adresse e-mail de la personne à qui vous voulez envoyer un e-mail
        String recipientEmail = "example@example.com";

        // Créer une intention pour envoyer un e-mail
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + recipientEmail));

        // Vérifie si une application e-mail est disponible sur l'appareil
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Démarrer l'intention
            startActivity(intent);
        } else {
            // Gérer le cas où aucune application e-mail n'est disponible
            Toast.makeText(this, "Aucune application e-mail n'est disponible.", Toast.LENGTH_SHORT).show();
        }
    }



}
