package com.example.tp_leboncoin;

import android.content.Context;
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

    public DbAdAdapter(Context context, Cursor c, int layout) {
        super(context, c);
        item_layout = layout;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(item_layout, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // TextView idTextView = (TextView) view.findViewById(...)
        TextView titleTextView = (TextView) view.findViewById(R.id.adName);
        TextView addressTextView = (TextView) view.findViewById(R.id.adAddress);
        ImageView imageView = (ImageView) view.findViewById(R.id.adImage);
        String id = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper._ID));
        String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
        String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
        String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));
        // idTextView.setText(id);
        titleTextView.setText(title);
        addressTextView.setText(address);

        // Utilisez Glide.with(context) pour charger l'image depuis l'URL
        Glide.with(context)
                .load(image) // Charge l'image depuis l'URL spécifiée
                .into(imageView); // Affiche l'image dans ImageView
    }

}
