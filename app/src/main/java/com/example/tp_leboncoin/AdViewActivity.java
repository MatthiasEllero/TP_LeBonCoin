package com.example.tp_leboncoin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);

        // Récupérer les données de l'annonce depuis l'intent
        Intent intent = getIntent();
        if (intent != null) {
            int adImage = intent.getIntExtra("ad_image", -1);
            String adTitle = intent.getStringExtra("ad_title");
            String adAddress = intent.getStringExtra("ad_address");

            // Afficher les détails de l'annonce dans les vues appropriées
            ImageView imageView = findViewById(R.id.adImageView);
            TextView titleTextView = findViewById(R.id.adTitleTextView);
            TextView addressTextView = findViewById(R.id.adAddressTextView);

            imageView.setImageResource(adImage);
            titleTextView.setText(adTitle);
            addressTextView.setText(adAddress);
        }
    }
}
