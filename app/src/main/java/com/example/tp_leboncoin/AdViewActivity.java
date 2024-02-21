package com.example.tp_leboncoin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tp_leboncoin.sqlite.DBManager;

public class AdViewActivity extends AppCompatActivity {

    private String phoneNumber; // Variable pour stocker le numéro de téléphone de l'annonce

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);

        // Récupérer l'ID de l'annonce depuis l'intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ad_id")) {
            int adId = intent.getIntExtra("ad_id", -1);

            // Récupérer les détails de l'annonce à partir de la base de données en fonction de l'ID
            DBManager dbManager = DBManager.getDBManager(this);
            dbManager.open();
            AdModel adModel = dbManager.getById(adId);
            dbManager.close();

            if (adModel != null) {
                // Afficher les détails de l'annonce dans les vues appropriées
                ImageView imageView = findViewById(R.id.adImageView);
                TextView titleTextView = findViewById(R.id.adTitleTextView);
                TextView addressTextView = findViewById(R.id.adAddressTextView);
                TextView phoneTextView = findViewById(R.id.adPhoneTextView); // Ajout du champ téléphone

                Glide.with(this)
                        .load(adModel.getImage())
                        .into(imageView);

                titleTextView.setText(adModel.getTitle());
                addressTextView.setText(adModel.getAddress());
                phoneTextView.setText(adModel.getPhone()); // Afficher le numéro de téléphone

                phoneNumber = adModel.getPhone(); // Stocker le numéro de téléphone dans la variable phoneNumber
            }
        }
    }

    // Méthode pour composer le numéro de téléphone lorsque l'utilisateur clique sur le bouton d'appel
    public void callPhoneNumber(View view) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
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
        } else {
            // Gérer le cas où le numéro de téléphone est vide ou null
            Toast.makeText(this, "Numéro de téléphone non disponible.", Toast.LENGTH_SHORT).show();
        }
    }
}
