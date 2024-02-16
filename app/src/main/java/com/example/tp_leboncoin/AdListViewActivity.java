package com.example.tp_leboncoin;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.tp_leboncoin.sqlite.DBHelper;
import com.example.tp_leboncoin.sqlite.DBManager;

import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    List<AdModel> adList = AdListManager.adList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DBManager dbManager = DBManager.getDBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        CursorAdapter adapter = new DbAdAdapter(this, cursor, R.layout.item_listview_ad);
        adapter.notifyDataSetChanged();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}

