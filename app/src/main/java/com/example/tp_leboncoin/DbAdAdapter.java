package com.example.tp_leboncoin;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tp_leboncoin.sqlite.DBHelper;

public class DbAdAdapter extends CursorAdapter {
    private final int item_layout;
    private Context mContext;

    public DbAdAdapter(Context context, Cursor c, int layout) {
        super(context, c);
        item_layout = layout;
        mContext = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(item_layout, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView titleTextView = view.findViewById(R.id.adName);
        TextView addressTextView = view.findViewById(R.id.adAddress);
        ImageView imageView = view.findViewById(R.id.adImage);
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper._ID));
        String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
        String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
        String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));

        titleTextView.setText(title);
        addressTextView.setText(address);

        Glide.with(context)
                .load(image)
                .into(imageView);

        // Ajouter un OnClickListener à la vue de la card
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer l'ID de l'annonce et lancer l'activité de vue détaillée
                Intent intent = new Intent(mContext, AdViewActivity.class);
                intent.putExtra("ad_id", id);
                mContext.startActivity(intent);
            }
        });
    }

}
