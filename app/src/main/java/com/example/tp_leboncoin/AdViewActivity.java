package com.example.tp_leboncoin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tp_leboncoin.sqlite.DBHelper;
import com.example.tp_leboncoin.sqlite.DBManager;

public class AdViewActivity extends AppCompatActivity {

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

                Glide.with(this)
                        .load(adModel.getImage())
                        .into(imageView);

                titleTextView.setText(adModel.getTitle());
                addressTextView.setText(adModel.getAddress());
            }
        }
    }
}
